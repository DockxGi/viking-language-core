package be.stadr.vikinglanguagecore.service.exception;

import be.stadr.vikinglanguagecore.domain.WordType;

public class WordNotFound extends RuntimeException {

    public WordNotFound(int wordId) {
        super(String.format("Word with id \"%d\" not found.", wordId));
    }

    public WordNotFound(int wordId, WordType wordType) {
        super(String.format("%s with id \"%d\" not found.", wordType.name(), wordId));
    }
}
