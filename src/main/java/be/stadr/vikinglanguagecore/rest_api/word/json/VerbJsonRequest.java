package be.stadr.vikinglanguagecore.rest_api.word.json;

import be.stadr.vikinglanguagecore.service.WordRequest;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class VerbJsonRequest implements WordRequest {
    @NotBlank
    @Size(min = 1, max = 100)
    private String latinNotation;

    @NotNull
    private Boolean mostFrequentInSagas;

    private Boolean strong;

    @Min(value = 1, message = "conjugation should be 1,2,3 or 4")
    @Max(value = 4, message = "conjugation should be 1,2,3 or 4")
    private Integer conjugation;

    @Override
    public boolean isMostFrequentInSagas() {
        return mostFrequentInSagas;
    }
}
