package be.stadr.vikinglanguagecore.domain;

import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "2")
@NoArgsConstructor
public class Verb extends Word {

    private Boolean strong;
    private Integer conjugation;

    public Verb(String latinNotation, boolean mostFrequentInSagas, Boolean strong, Integer conjugation) {
        super(latinNotation, mostFrequentInSagas);
        this.strong = strong;
        this.conjugation = conjugation;
    }
}
