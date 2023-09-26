package be.stadr.vikinglanguagecore.domain.exception;

public class ConjugationNotPossible extends RuntimeException {
    public ConjugationNotPossible(String message) {
        super(message);
    }
}
