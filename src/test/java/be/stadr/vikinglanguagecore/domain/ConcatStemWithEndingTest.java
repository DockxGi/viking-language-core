package be.stadr.vikinglanguagecore.domain;

import be.stadr.vikinglanguagecore.domain.conjugation.ConjugationUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConcatStemWithEndingTest {

    @Test
    public void stemSpyrjKeepsOriginalStemIfFollowedByU(){
        String result = ConjugationUtil.concatStemWithEnding("spyrj", "um");

        assertEquals("spyrjum", result);
    }

    @Test
    public void stemSpyrjKeepsOriginalStemIfFollowedByA(){
        String result = ConjugationUtil.concatStemWithEnding("spyrj", "a");

        assertEquals("spyrja", result);
    }

    @Test
    public void stemSpyrjLosesJifEndingNotAorU(){
        String result = ConjugationUtil.concatStemWithEnding("spyrj", "");
        assertEquals("spyr", result);

        String result2 = ConjugationUtil.concatStemWithEnding("spyrj", "r");
        assertEquals("spyrr", result2);

        String result3 = ConjugationUtil.concatStemWithEnding("spyrj", "i∂");
        assertEquals("spyri∂", result3);
    }
}
