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
public final class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(UserRegistrationRequest requestDto, HttpServletRequest request) {
        if (checkUserExist(requestDto.getEmail())) {
            throw new UserAlreadyExistException("User with this email already exist");
        }
        User newUser = new User();
        newUser.setEmail(requestDto.getEmail());
        newUser.setFirstName(requestDto.getFirstName());
        newUser.setLastName(requestDto.getLastName());
        newUser.setRole(Role.USER);
        newUser.setRegistredAt(LocalDate.now());
        newUser.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        userRepository.save(newUser);
        authenticateAfterRegistration(request, requestDto.getEmail(), requestDto.getPassword());

    }


    private boolean checkUserExist(String username) {
        return userRepository.findByEmail(username).isPresent();
    }

    private void authenticateAfterRegistration(HttpServletRequest request, String username, String password) {
        try {
            request.login(username, password);
        } catch (ServletException e) {
            System.err.println("An error occurred during the auto authentication after user registration");
            e.printStackTrace();
        }
    }
}
