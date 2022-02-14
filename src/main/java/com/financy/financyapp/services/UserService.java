package com.financy.financyapp.services;

import com.financy.financyapp.enums.Role;
import com.financy.financyapp.exceprions.UserAlreadyExistException;
import com.financy.financyapp.models.User;
import com.financy.financyapp.models.dto.UserRegistrationRequest;
import com.financy.financyapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

@Service
public record UserService(UserRepository userRepository,
                          PasswordEncoder passwordEncoder) {

    @Autowired
    public UserService {
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
