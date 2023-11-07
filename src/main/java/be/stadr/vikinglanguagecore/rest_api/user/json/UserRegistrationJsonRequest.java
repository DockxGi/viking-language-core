package be.stadr.vikinglanguagecore.rest_api.user.json;

import be.stadr.vikinglanguagecore.service.CreateUserRequest;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UserRegistrationJsonRequest implements CreateUserRequest {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String confirmPassword;

}
