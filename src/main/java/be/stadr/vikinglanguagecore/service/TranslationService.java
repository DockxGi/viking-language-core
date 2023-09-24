package be.stadr.vikinglanguagecore.service;

import be.stadr.vikinglanguagecore.domain.Translation;
import be.stadr.vikinglanguagecore.domain.Word;
import be.stadr.vikinglanguagecore.persist.TranslationRepository;
import be.stadr.vikinglanguagecore.persist.WordRepository;
import be.stadr.vikinglanguagecore.service.exception.WordNotFound;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TranslationService {

    private final WordRepository wordRepository;

    private final TranslationRepository translationRepository;

    @Transactional
    public void addTranslation(AddTranslationRequest request){
        int wordId = request.getWordId();
        Optional<Word> optionalWord = wordRepository.findById(wordId);
        Word word = optionalWord.orElseThrow(() -> new WordNotFound(wordId));

        String languageCode = request.getLanguageCode();
        String text = request.getText();
        Optional<Translation> optionalTranslation = translationRepository.findByLanguageCodeAndText(languageCode, text);

        Translation translation = optionalTranslation.orElseGet(() -> new Translation(languageCode, text));
        translation.addWord(word);
        translationRepository.save(translation);
    }

}
