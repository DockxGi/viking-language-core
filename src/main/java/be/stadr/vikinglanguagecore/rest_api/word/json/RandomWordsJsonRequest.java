package be.stadr.vikinglanguagecore.rest_api.word.json;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RandomWordsJsonRequest {

    private int amount;
    private Boolean mostFrequentInSagas;

}
