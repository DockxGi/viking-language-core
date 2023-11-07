package be.stadr.vikinglanguagecore.service;

import be.stadr.vikinglanguagecore.domain.user.UserRegistration;
import be.stadr.vikinglanguagecore.persist.UserRegistrationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class UserRegistrationService {

    private final UserRegistrationRepository repository;

    @Transactional
    public void createUserRegistration(CreateUserRequest request){
        String firstName = request.getFirstName();
        String lastName = request.getLastName();
        String email = request.getEmail();
        String password = request.getPassword();

        UserRegistration userRegistration = new UserRegistration(firstName, lastName, email, password);

        repository.save(userRegistration);
    }

}
