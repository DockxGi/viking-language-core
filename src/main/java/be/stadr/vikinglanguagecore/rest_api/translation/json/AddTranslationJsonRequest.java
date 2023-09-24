package be.stadr.vikinglanguagecore.rest_api.translation.json;

import be.stadr.vikinglanguagecore.service.AddTranslationRequest;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * The request to add a translation to a Word.
 */
@Getter
@Setter
public class AddTranslationJsonRequest implements AddTranslationRequest {

    @NotNull
    private Integer wordId;

    @NotBlank
    @Size(min = 2, max = 2)
    private String languageCode;

    @NotBlank
    @Size(min = 1)
    private String text;

    public int getWordId(){
        return wordId;
    }
}
