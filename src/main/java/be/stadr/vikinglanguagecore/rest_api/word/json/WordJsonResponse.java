package be.stadr.vikinglanguagecore.rest_api.word.json;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Non-detailed json response that is general for all types of words.
 */
@Getter
@Setter
@AllArgsConstructor
public class WordJsonResponse {

    private int id;

    private String latinNotation;

}
