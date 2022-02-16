package link.enumerableentity.financy.services;

import link.enumerableentity.financy.enums.Role;
import link.enumerableentity.financy.exceprions.UserAlreadyExistException;
import link.enumerableentity.financy.models.User;
import link.enumerableentity.financy.models.dto.UserRegistrationRequest;
import link.enumerableentity.financy.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(UserRegistrationRequest requestDto, HttpServletRequest request) {
        if (checkUserExist(requestDto.getEmail())) {
            throw new UserAlreadyExistException("User with this email already exist");
        }

        User newUser = mapToUser(requestDto);

        newUser.setRole(Role.USER);
        newUser.setRegistredAt(LocalDate.now());
        User savedUser = userRepository.save(newUser);

        authenticateAfterRegistration(request, requestDto.getEmail(), requestDto.getPassword());
        return savedUser;
    }

    private boolean checkUserExist(String username) {
        return userRepository.findByEmail(username).isPresent();
    }

    void authenticateAfterRegistration(HttpServletRequest request, String username, String password) {
        try {
            request.login(username, password);
        } catch (ServletException e) {
            System.err.println("An error occurred during the auto authentication after user registration");
            e.printStackTrace();
        }
    }

    private User mapToUser(UserRegistrationRequest dto){
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        return user;
    }
}
