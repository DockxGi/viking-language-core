package be.stadr.vikinglanguagecore.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DetermineStemOfWeakVerbsTest {

    @Test
    public void sgStemOfKalla(){
        String stem = ConjugationUtil.determineStem("kalla", 1, Number.SG);

        assertEquals("kalla", stem);
    }

    @Test
    public void sgStemOfMaela(){
        String stem = ConjugationUtil.determineStem("mæla", 2, Number.SG);

        assertEquals("mæli", stem);
    }

    @Test
    public void sgStemOfSpyrja(){
        String stem = ConjugationUtil.determineStem("spyrja", 3, Number.SG);

        assertEquals("spyrj", stem);
    }

    @Test
    public void sgStemOfThola(){
        String stem = ConjugationUtil.determineStem("þola", 4, Number.SG);

        assertEquals("þoli", stem);
    }

    @Test
    public void plStemOfKalla(){
        String stem = ConjugationUtil.determineStem("kalla", 1, Number.PL);

        assertEquals("kall", stem);
    }

    @Test
    public void plStemOfMaela(){
        String stem = ConjugationUtil.determineStem("mæla", 2, Number.PL);

        assertEquals("mæl", stem);
    }

    @Test
    public void plStemOfSpyrja(){
        String stem = ConjugationUtil.determineStem("spyrja", 3, Number.PL);

        assertEquals("spyrj", stem);
    }

    @Test
    public void plStemOfThola(){
        String stem = ConjugationUtil.determineStem("þola", 4, Number.PL);

        assertEquals("þol", stem);
    }
}
