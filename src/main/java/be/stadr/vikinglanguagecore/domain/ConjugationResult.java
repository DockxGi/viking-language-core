package be.stadr.vikinglanguagecore.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * The result of applying a single conjugation. Example: ek em (result of conjugation of vera in 1st person singular)
 */
@Setter
@Getter
public class ConjugationResult {
    String subject;
    String verb;
}
