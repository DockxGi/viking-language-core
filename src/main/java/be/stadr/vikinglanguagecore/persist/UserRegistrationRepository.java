package be.stadr.vikinglanguagecore.persist;

import be.stadr.vikinglanguagecore.domain.user.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRegistrationRepository extends JpaRepository<UserRegistration, Integer> {

}
