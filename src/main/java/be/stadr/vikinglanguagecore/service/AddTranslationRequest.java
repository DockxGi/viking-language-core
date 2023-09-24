package be.stadr.vikinglanguagecore.service;

public interface AddTranslationRequest {
    int getWordId();
    String getLanguageCode();
    String getText();
}
