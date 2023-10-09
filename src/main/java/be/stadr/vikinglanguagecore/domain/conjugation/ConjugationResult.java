package be.stadr.vikinglanguagecore.domain.conjugation;

import be.stadr.vikinglanguagecore.domain.Number;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * The result of applying a single conjugation. Example: ek em (result of conjugation of vera in 1st person singular)
 */
@Setter
@Getter
@AllArgsConstructor
public class ConjugationResult {
    int person;
    Number number;
    String subject;
    String verb;
}
