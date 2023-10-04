package be.stadr.vikinglanguagecore.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue(value = "1")
@NoArgsConstructor
public class Noun extends Word {

    @Enumerated(EnumType.ORDINAL)
    @Getter
    @Setter
    private Gender gender;

    @Getter
    @Setter
    private Boolean strong;

    public Noun(String latinNotation, boolean mostFrequentInSagas, Gender gender, Boolean strong) {
        super(latinNotation, mostFrequentInSagas);
        this.gender = gender;
        this.strong = strong;
    }
}
