package link.enumerableentity.financy.services;

import link.enumerableentity.financy.enums.Role;
import link.enumerableentity.financy.exceprions.UserAlreadyExistException;
import link.enumerableentity.financy.models.User;
import link.enumerableentity.financy.models.dto.UserRegistrationRequest;
import link.enumerableentity.financy.repositories.UserRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @Mock
    PasswordEncoder passwordEncoder;

    @InjectMocks
    UserService userService;

    User testUser = new User();;
    UserRegistrationRequest testRegistrationRequest = new UserRegistrationRequest();

    @Test
    @DisplayName("User registration test")
    void registerUser() {
        when(passwordEncoder.encode(any())).thenReturn("encodedPassword");
        when(userRepository.findByEmail("testUserDataExist@mail.com")).thenReturn(Optional.of(new User()));
        when(userRepository.save(testUser)).thenReturn(testUser);

        testRegistrationRequest.setEmail("testUserDataExist@mail.com");
        testRegistrationRequest.setFirstName("TestFirstName");
        testRegistrationRequest.setLastName("TestLastName");
        testRegistrationRequest.setPassword("testPassword");


        testUser.setEmail(testRegistrationRequest.getEmail());
        testUser.setFirstName(testRegistrationRequest.getFirstName());
        testUser.setLastName(testRegistrationRequest.getLastName());
        testUser.setRole(Role.USER);
        testUser.setRegistredAt(LocalDate.now());
        testUser.setPassword(passwordEncoder.encode(testRegistrationRequest.getPassword()));


        UserService spyUserService = Mockito.spy(userService);


        doNothing().when(spyUserService).authenticateAfterRegistration(any(),any(),any());

        Assertions.assertThrows(UserAlreadyExistException.class ,()-> spyUserService.registerUser(testRegistrationRequest, null ),
                "Throw Exception when user already exist");

        testRegistrationRequest.setEmail("testUserDataNotExist@mail.com");
        testUser.setEmail(testRegistrationRequest.getEmail());

        Assertions.assertEquals(testUser, spyUserService.registerUser(testRegistrationRequest, null));
    }

    @Test
    void authenticateAfterRegistration() {
    }
}