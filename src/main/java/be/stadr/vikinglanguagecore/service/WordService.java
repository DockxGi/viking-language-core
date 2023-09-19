package be.stadr.vikinglanguagecore.service;

import be.stadr.vikinglanguagecore.domain.Noun;
import be.stadr.vikinglanguagecore.domain.Verb;
import be.stadr.vikinglanguagecore.domain.Word;
import be.stadr.vikinglanguagecore.persist.WordRepository;
import be.stadr.vikinglanguagecore.rest_api.word.json.NounJsonRequest;
import be.stadr.vikinglanguagecore.rest_api.word.json.VerbJsonRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class WordService {

    private final WordRepository repository;

    @Transactional
    public void createNoun(NounJsonRequest request) {
        String latinNotation = request.getLatinNotation();
        boolean mostFrequentInSagas = request.isMostFrequentInSagas();

        Word word = new Noun(latinNotation, mostFrequentInSagas);
        repository.save(word);
    }

    public void createVerb(VerbJsonRequest request) {
        String latinNotation = request.getLatinNotation();
        boolean mostFrequentInSagas = request.isMostFrequentInSagas();

        Word word = new Verb(latinNotation, mostFrequentInSagas);
        repository.save(word);
    }
}
