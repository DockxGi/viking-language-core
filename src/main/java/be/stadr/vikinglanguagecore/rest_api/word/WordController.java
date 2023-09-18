package be.stadr.vikinglanguagecore.rest_api.word;

import be.stadr.vikinglanguagecore.rest_api.word.json.WordJsonRequest;
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
    @PostMapping
    public void create(@RequestBody @Validated WordJsonRequest request){
        wordService.create(request);
    }

}
