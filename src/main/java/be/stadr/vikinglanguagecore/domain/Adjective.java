package be.stadr.vikinglanguagecore.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "3")
public class Adjective extends Word {

}
