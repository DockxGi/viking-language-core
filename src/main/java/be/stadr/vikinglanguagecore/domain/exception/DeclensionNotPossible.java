package be.stadr.vikinglanguagecore.domain.exception;

public class DeclensionNotPossible extends RuntimeException {
    public DeclensionNotPossible(String message) {
        super(message);
    }
}
