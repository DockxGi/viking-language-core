package be.stadr.vikinglanguagecore.rest_api.word;

import be.stadr.vikinglanguagecore.rest_api.word.json.NounJsonRequest;
import be.stadr.vikinglanguagecore.rest_api.word.json.VerbJsonRequest;
import be.stadr.vikinglanguagecore.service.WordService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("word")
@AllArgsConstructor
public class WordController {

    private final WordService wordService;

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


}
