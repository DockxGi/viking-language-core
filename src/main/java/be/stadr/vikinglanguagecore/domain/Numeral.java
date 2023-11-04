package be.stadr.vikinglanguagecore.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "4")
public class Numeral extends Word {

}
