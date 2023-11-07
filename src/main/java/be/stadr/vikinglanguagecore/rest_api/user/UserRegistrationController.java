package be.stadr.vikinglanguagecore.rest_api.user;

import be.stadr.vikinglanguagecore.rest_api.user.json.UserRegistrationJsonRequest;
import be.stadr.vikinglanguagecore.service.UserRegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user/registration")
@AllArgsConstructor
public class UserRegistrationController {

    private final UserRegistrationService userRegistrationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@RequestBody @Validated UserRegistrationJsonRequest request){
        userRegistrationService.createUserRegistration(request);
    }
}
