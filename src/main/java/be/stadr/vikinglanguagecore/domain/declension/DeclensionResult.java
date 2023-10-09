package be.stadr.vikinglanguagecore.domain.declension;

import be.stadr.vikinglanguagecore.domain.Case;
import be.stadr.vikinglanguagecore.domain.Number;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DeclensionResult {
    private Case theCase;
    private Number number;
    private String noun;
}
