package link.enumerableentity.financy.models.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserRegistrationRequest {

    @NotBlank
    @Email
    private  String email;
    @NotBlank
    @Size(min = 8, max = 25, message = "Password is empty, too long or too short")
    private  String password;
    @NotBlank
    @Size(min = 5, max = 15, message = "First name is empty, too long or too short")
    private  String firstName;
    @NotBlank
    @Size(min = 5, max = 15, message = "Last name is empty, too long or too short")
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