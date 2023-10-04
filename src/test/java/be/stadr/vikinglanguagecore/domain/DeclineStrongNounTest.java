package be.stadr.vikinglanguagecore.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static be.stadr.vikinglanguagecore.domain.Gender.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeclineStrongNounTest {

    @Test
    public void declineHestr(){
        Noun noun = new Noun("hestr", true, MALE, true);

        List<DeclensionResult> results = DeclensionUtil.declineNoun(noun);

        //sg
        assertDeclensionResult(results.get(0), Case.NOM, Number.SG, "hestr");
        assertDeclensionResult(results.get(1), Case.ACC, Number.SG, "hest");
        assertDeclensionResult(results.get(2), Case.DAT, Number.SG, "hesti");
        assertDeclensionResult(results.get(3), Case.GEN, Number.SG, "hests");

        //pl
        assertDeclensionResult(results.get(4), Case.NOM, Number.PL, "hestar");
        assertDeclensionResult(results.get(5), Case.ACC, Number.PL, "hesta");
        assertDeclensionResult(results.get(6), Case.DAT, Number.PL, "hestum");
        assertDeclensionResult(results.get(7), Case.GEN, Number.PL, "hesta");
    }

    @Test
    public void declineLeid(){
        Noun noun = new Noun("lei∂", true, FEMALE, true);

        List<DeclensionResult> results = DeclensionUtil.declineNoun(noun);

        //sg
        assertDeclensionResult(results.get(0), Case.NOM, Number.SG, "lei∂");
        assertDeclensionResult(results.get(1), Case.ACC, Number.SG, "lei∂");
        assertDeclensionResult(results.get(2), Case.DAT, Number.SG, "lei∂");
        assertDeclensionResult(results.get(3), Case.GEN, Number.SG, "lei∂ar");

        //pl
        assertDeclensionResult(results.get(4), Case.NOM, Number.PL, "lei∂ir");
        assertDeclensionResult(results.get(5), Case.ACC, Number.PL, "lei∂ir");
        assertDeclensionResult(results.get(6), Case.DAT, Number.PL, "lei∂um");
        assertDeclensionResult(results.get(7), Case.GEN, Number.PL, "lei∂a");
    }

    @Test
    public void declineThing(){
        Noun noun = new Noun("þing", true, NEUTER, true);

        List<DeclensionResult> results = DeclensionUtil.declineNoun(noun);

        //sg
        assertDeclensionResult(results.get(0), Case.NOM, Number.SG, "þing");
        assertDeclensionResult(results.get(1), Case.ACC, Number.SG, "þing");
        assertDeclensionResult(results.get(2), Case.DAT, Number.SG, "þingi");
        assertDeclensionResult(results.get(3), Case.GEN, Number.SG, "þings");

        //pl
        assertDeclensionResult(results.get(4), Case.NOM, Number.PL, "þing");
        assertDeclensionResult(results.get(5), Case.ACC, Number.PL, "þing");
        assertDeclensionResult(results.get(6), Case.DAT, Number.PL, "þingum");
        assertDeclensionResult(results.get(7), Case.GEN, Number.PL, "þinga");
    }

    private void assertDeclensionResult(DeclensionResult result, Case expectedCase, Number expectedNum, String expectedNoun) {
        assertEquals(expectedCase, result.getTheCase());
        assertEquals(expectedNum, result.getNumber());
        assertEquals(expectedNoun, result.getNoun());
    }

}
