package be.stadr.vikinglanguagecore.rest_api.translation;

import be.stadr.vikinglanguagecore.rest_api.translation.json.AddTranslationJsonRequest;
import be.stadr.vikinglanguagecore.service.TranslationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("translation")
@AllArgsConstructor
public class TranslationController {

    private final TranslationService translationService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    public void addTranslation(@RequestBody @Validated AddTranslationJsonRequest request){
        translationService.addTranslation(request);
    }
}
