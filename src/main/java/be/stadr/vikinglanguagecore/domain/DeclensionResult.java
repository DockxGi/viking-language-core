package be.stadr.vikinglanguagecore.domain;

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
