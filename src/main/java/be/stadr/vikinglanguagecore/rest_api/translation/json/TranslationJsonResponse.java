package be.stadr.vikinglanguagecore.rest_api.translation.json;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TranslationJsonResponse {
    private int id;
    private String languageCode;
    private String text;
}
