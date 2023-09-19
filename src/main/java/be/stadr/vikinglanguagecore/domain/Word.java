package be.stadr.vikinglanguagecore.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.InheritanceType.SINGLE_TABLE;

/**
 * An Old Norse (ON) word. In reality a word can have many variations.
 * An instance of this class only represents the 'normal' variation:
 * - for nouns that is the word in the nominative case (example: konungr, Herjólfr)
 * - for adjectives that is the word in the nominative case (example: margr, gó∂r)
 * - for verbs that is the infinitive (example: vera, fara)
 */
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.INTEGER)
public abstract class Word {

    @Id
    @GeneratedValue(strategy= AUTO)
    private Integer id;



    private String latinNotation;
    private boolean mostFrequentInSagas;

    public Word(String latinNotation, boolean mostFrequentInSagas) {
        this.latinNotation = latinNotation;
        this.mostFrequentInSagas = mostFrequentInSagas;
    }
}
