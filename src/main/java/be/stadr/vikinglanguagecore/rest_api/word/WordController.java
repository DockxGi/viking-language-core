package be.stadr.vikinglanguagecore.rest_api.word;

import be.stadr.vikinglanguagecore.domain.ConjugationResult;
import be.stadr.vikinglanguagecore.domain.Number;
import be.stadr.vikinglanguagecore.domain.Translation;
import be.stadr.vikinglanguagecore.domain.Word;
import be.stadr.vikinglanguagecore.rest_api.translation.json.TranslationJsonResponse;
import be.stadr.vikinglanguagecore.rest_api.word.json.ConjugationResultJsonResponse;
import be.stadr.vikinglanguagecore.rest_api.word.json.NounJsonRequest;
import be.stadr.vikinglanguagecore.rest_api.word.json.VerbJsonRequest;
import be.stadr.vikinglanguagecore.rest_api.word.json.WordJsonResponse;
import be.stadr.vikinglanguagecore.service.TranslationService;
import be.stadr.vikinglanguagecore.service.WordService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("word")
@AllArgsConstructor
public class WordController {

    private final WordService wordService;
    private final TranslationService translationService;

    @ResponseStatus(CREATED)
    @PostMapping(value = "noun")
    public void createNoun(@RequestBody @Validated NounJsonRequest request){
        wordService.createNoun(request);
    }

    @ResponseStatus(CREATED)
    @PostMapping(value = "verb")
    public void createVerb(@RequestBody @Validated VerbJsonRequest request){
        wordService.createVerb(request);
    }

    @ResponseStatus(OK)
    @GetMapping(value = "verb/{id}/conjugation")
    public ArrayList<ConjugationResultJsonResponse> conjugateVerb(@PathVariable int id){
        List<ConjugationResult> results = wordService.conjugateVerb(id);

        return conjugationResultsToJsonResponse(results);

    }

    private ArrayList<ConjugationResultJsonResponse> conjugationResultsToJsonResponse(List<ConjugationResult> results) {
        ArrayList<ConjugationResultJsonResponse> response = new ArrayList<>();
        results.forEach(result -> {
            int person = result.getPerson();
            Number number = result.getNumber();
            String subject = result.getSubject();
            String verb = result.getVerb();

            ConjugationResultJsonResponse cjr = new ConjugationResultJsonResponse(person, number, subject, verb);
            response.add(cjr);
        });
        return response;
    }

    @ResponseStatus(OK)
    @GetMapping()
    public List<WordJsonResponse> getAllWords(){
        Iterable<Word> allWords = wordService.getAll();
        return wordsToWordJsonResponse(allWords);
    }

    @ResponseStatus(OK)
    @GetMapping(value = "/{id}/translation")
    public List<TranslationJsonResponse> getTranslations(@PathVariable("id") int wordId){
        List<Translation> translation = translationService.findByWord(wordId);

        return translation.stream()
                .map(t -> new TranslationJsonResponse(t.getId(), t.getLanguageCode(), t.getText()))
                .toList();
    }

    private List<WordJsonResponse> wordsToWordJsonResponse(Iterable<Word> allWords) {
        List<WordJsonResponse> response = new ArrayList<>();
        allWords.forEach(word -> {
            Integer id = word.getId();
            String latinNotation = word.getLatinNotation();
            WordJsonResponse wordJsonResponse = new WordJsonResponse(id, latinNotation);
            response.add(wordJsonResponse);
        });
        return response;
    }

}
