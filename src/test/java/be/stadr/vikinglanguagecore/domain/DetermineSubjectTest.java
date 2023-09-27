package be.stadr.vikinglanguagecore.domain;

import org.junit.jupiter.api.Test;

import static be.stadr.vikinglanguagecore.domain.Number.PL;
import static be.stadr.vikinglanguagecore.domain.Number.SG;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DetermineSubjectTest {

    @Test
    public void firstPersonSg(){
        String subject = ConjugationUtil.determineSubject(1, SG);

        assertEquals("ek", subject);
    }

    @Test
    public void secondPersonSg(){
        String subject = ConjugationUtil.determineSubject(2, SG);

        assertEquals("þú", subject);
    }

    @Test
    public void thirdPersonSg(){
        String subject = ConjugationUtil.determineSubject(3, SG);

        assertEquals("hann/hon/þat", subject);
    }

    @Test
    public void firstPersonPl(){
        String subject = ConjugationUtil.determineSubject(1, PL);

        assertEquals("vér/vit", subject);
    }

    @Test
    public void secondPersonPl(){
        String subject = ConjugationUtil.determineSubject(2, PL);

        assertEquals("þér/þit", subject);
    }

    @Test
    public void thirdPersonPl(){
        String subject = ConjugationUtil.determineSubject(3, PL);

        assertEquals("þeir/þær/þau", subject);
    }
}
