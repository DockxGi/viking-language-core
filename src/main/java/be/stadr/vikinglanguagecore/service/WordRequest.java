package be.stadr.vikinglanguagecore.service;

/**
 * Represents a request to create/update a Word.
 */
public interface WordRequest {
    String getLatinNotation();
    boolean isMostFrequentInSagas();
}
