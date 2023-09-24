package be.stadr.vikinglanguagecore.service.exception;

public class WordNotFound extends RuntimeException {

    public WordNotFound(int wordId) {
        super(String.format("Word with id \"%d\" not found."));
    }

}
