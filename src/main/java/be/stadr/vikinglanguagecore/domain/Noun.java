package be.stadr.vikinglanguagecore.domain;

import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "1")
@NoArgsConstructor
public class Noun extends Word {
    public Noun(String latinNotation, boolean mostFrequentInSagas) {
        super(latinNotation, mostFrequentInSagas);
    }
}
