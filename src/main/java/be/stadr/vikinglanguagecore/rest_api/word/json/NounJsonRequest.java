package be.stadr.vikinglanguagecore.rest_api.word.json;

import be.stadr.vikinglanguagecore.service.WordRequest;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class NounJsonRequest implements WordRequest {

    @NotBlank
    @Size(min = 1, max = 100)
    private String latinNotation;

    @NotNull
    private Boolean mostFrequentInSagas;

    private String gender;

    @Override
    public boolean isMostFrequentInSagas() {
        return mostFrequentInSagas;
    }
}
