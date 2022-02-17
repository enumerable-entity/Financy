package link.enumerableentity.financy.models.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserRegistrationRequest {

    @NotBlank(message = "Email can`t be empty")
    @Email(message = "Not valid email address")
    private  String email;

    @Size(min = 8, max = 25, message = "Should be from 8 to 25 symbols")
    private  String password;

    @Size(min = 3, max = 15, message = "Should be from 3 to 15 symbols")
    private  String firstName;

    @Size(min = 3, max = 15, message = "Should be from 3 to 15 symbols")
    private  String lastName;


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}