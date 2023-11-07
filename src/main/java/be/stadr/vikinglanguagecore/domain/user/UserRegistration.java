package be.stadr.vikinglanguagecore.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.AUTO;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class UserRegistration {

    public UserRegistration(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy= AUTO)
    private Integer id;

    private String firstName;
    private String lastName;
    private String email;
    private String password;

}
