package be.stadr.vikinglanguagecore.domain;

import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "2")
@NoArgsConstructor
public class Verb extends Word {
    public Verb(String latinNotation, boolean mostFrequentInSagas) {
        super(latinNotation, mostFrequentInSagas);
    }
}
