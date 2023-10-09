package be.stadr.vikinglanguagecore.domain;

import be.stadr.vikinglanguagecore.domain.conjugation.ConjugationResult;
import be.stadr.vikinglanguagecore.domain.conjugation.ConjugationUtil;
import org.junit.jupiter.api.Test;

import java.util.List;

import static be.stadr.vikinglanguagecore.domain.Number.PL;
import static be.stadr.vikinglanguagecore.domain.Number.SG;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ConjugateWeakVerbTest {
    @Test
    public void conjugateLeita(){
        Verb verb = new Verb("leita", true, false, 1);

        List<ConjugationResult> results = ConjugationUtil.conjugateVerb(verb);

        //sg
        assertValidationResult(results.get(0), SG, 1, "ek", "leita");
        assertValidationResult(results.get(1), SG, 2, "þú", "leitar");
        assertValidationResult(results.get(2), SG, 3, "hann/hon/þat", "leitar");

        //pl
        assertValidationResult(results.get(3), PL, 1, "vér/vit", "leitum");
        assertValidationResult(results.get(4), PL, 2, "þér/þit", "leiti∂");
        assertValidationResult(results.get(5), PL, 3, "þeir/þær/þau", "leita");
    }

    @Test
    public void conjugateMaela(){
        Verb verb = new Verb("mæla", true, false, 2);

        List<ConjugationResult> results = ConjugationUtil.conjugateVerb(verb);

        //sg
        assertValidationResult(results.get(0), SG, 1, "ek", "mæli");
        assertValidationResult(results.get(1), SG, 2, "þú", "mælir");
        assertValidationResult(results.get(2), SG, 3, "hann/hon/þat", "mælir");

        //pl
        assertValidationResult(results.get(3), PL, 1, "vér/vit", "mælum");
        assertValidationResult(results.get(4), PL, 2, "þér/þit", "mæli∂");
        assertValidationResult(results.get(5), PL, 3, "þeir/þær/þau", "mæla");
    }

    //3rd conjugation is special because of the j-drop
    @Test
    public void conjugateTelja(){
        Verb verb = new Verb("telja", true, false, 3);

        List<ConjugationResult> results = ConjugationUtil.conjugateVerb(verb);

        //sg
        assertValidationResult(results.get(0), SG, 1, "ek", "tel");
        assertValidationResult(results.get(1), SG, 2, "þú", "telr");
        assertValidationResult(results.get(2), SG, 3, "hann/hon/þat", "telr");

        //pl
        assertValidationResult(results.get(3), PL, 1, "vér/vit", "teljum");
        assertValidationResult(results.get(4), PL, 2, "þér/þit", "teli∂");
        assertValidationResult(results.get(5), PL, 3, "þeir/þær/þau", "telja");
    }

    @Test
    public void conjugateThola(){
        Verb verb = new Verb("þola", true, false, 4);

        List<ConjugationResult> results = ConjugationUtil.conjugateVerb(verb);

        //sg
        assertValidationResult(results.get(0), SG, 1, "ek", "þoli");
        assertValidationResult(results.get(1), SG, 2, "þú", "þolir");
        assertValidationResult(results.get(2), SG, 3, "hann/hon/þat", "þolir");

        //pl
        assertValidationResult(results.get(3), PL, 1, "vér/vit", "þolum");
        assertValidationResult(results.get(4), PL, 2, "þér/þit", "þoli∂");
        assertValidationResult(results.get(5), PL, 3, "þeir/þær/þau", "þola");
    }

    private void assertValidationResult(ConjugationResult result, Number expectedNum, int expectedPerson, String expectedSubject, String expectedVerb){
        assertNotNull(result);
        assertEquals(expectedNum, result.getNumber());
        assertEquals(expectedPerson, result.getPerson());
        assertEquals(expectedSubject, result.getSubject());
        assertEquals(expectedVerb, result.getVerb());
    }
}
