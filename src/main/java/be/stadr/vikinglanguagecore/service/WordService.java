package be.stadr.vikinglanguagecore.service;

import be.stadr.vikinglanguagecore.domain.Word;
import be.stadr.vikinglanguagecore.persist.WordRepository;
import be.stadr.vikinglanguagecore.rest_api.word.json.WordJsonRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class WordService {

    private final WordRepository repository;

    @Transactional
    public void create(WordJsonRequest request) {
        Word word = new Word(request.getLatinNotation(), request.isMostFrequentInSagas());
        repository.save(word);
    }
}
