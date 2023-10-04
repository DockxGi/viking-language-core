package be.stadr.vikinglanguagecore.service;

import be.stadr.vikinglanguagecore.domain.*;
import be.stadr.vikinglanguagecore.persist.WordRepository;
import be.stadr.vikinglanguagecore.rest_api.word.json.NounJsonRequest;
import be.stadr.vikinglanguagecore.rest_api.word.json.VerbJsonRequest;
import be.stadr.vikinglanguagecore.service.exception.WordNotFound;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;

import static be.stadr.vikinglanguagecore.domain.WordType.VERB;

@Service
@AllArgsConstructor
public class WordService {

    private final WordRepository repository;

    @Transactional
    public void createNoun(NounJsonRequest request) {
        String latinNotation = request.getLatinNotation();
        boolean mostFrequentInSagas = request.isMostFrequentInSagas();

        Gender gender = EnumUtils.getEnumIgnoreCase(Gender.class, request.getGender());
        Boolean strong = request.getStrong();
        Word word = new Noun(latinNotation, mostFrequentInSagas, gender, strong);
        repository.save(word);
    }

    @Transactional
    public Iterable<Word> getAll() {
        return repository.findAll();
    }

    public void createVerb(VerbJsonRequest request) {
        String latinNotation = request.getLatinNotation();
        boolean mostFrequentInSagas = request.isMostFrequentInSagas();
        Boolean strong = request.getStrong();
        Integer conjugation = request.getConjugation();

        Word word = new Verb(latinNotation, mostFrequentInSagas, strong, conjugation);
        repository.save(word);
    }

    public List<ConjugationResult> conjugateVerb(int verbId) {
        Verb verb = repository.findByIdAndType(verbId, VERB.getNumber());

        if (verb == null){
            throw new WordNotFound(verbId, VERB);
        }

        return ConjugationUtil.conjugateVerb(verb);
    }
}
