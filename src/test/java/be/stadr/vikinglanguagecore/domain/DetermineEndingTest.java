package be.stadr.vikinglanguagecore.domain;

import be.stadr.vikinglanguagecore.domain.conjugation.ConjugationUtil;
import org.junit.jupiter.api.Test;

import static be.stadr.vikinglanguagecore.domain.Number.PL;
import static be.stadr.vikinglanguagecore.domain.Number.SG;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DetermineEndingTest {

    @Test
    public void firstPersonSg(){
        String subject = ConjugationUtil.determineEnding(1, SG);

        assertEquals("", subject);
    }

    @Test
    public void secondPersonSg(){
        String subject = ConjugationUtil.determineEnding(2, SG);

        assertEquals("r", subject);
    }

    @Test
    public void thirdPersonSg(){
        String subject = ConjugationUtil.determineEnding(3, SG);

        assertEquals("r", subject);
    }

    @Test
    public void firstPersonPl(){
        String subject = ConjugationUtil.determineEnding(1, PL);

        assertEquals("um", subject);
    }

    @Test
    public void secondPersonPl(){
        String subject = ConjugationUtil.determineEnding(2, PL);

        assertEquals("i∂", subject);
    }

    @Test
    public void thirdPersonPl(){
        String subject = ConjugationUtil.determineEnding(3, PL);

        assertEquals("a", subject);
    }
}
