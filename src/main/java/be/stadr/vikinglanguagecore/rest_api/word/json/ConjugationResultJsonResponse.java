package be.stadr.vikinglanguagecore.rest_api.word.json;

import be.stadr.vikinglanguagecore.domain.Number;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConjugationResultJsonResponse {
    private int person;
    private Number number;
    private String subject;
    private String verb;
}
