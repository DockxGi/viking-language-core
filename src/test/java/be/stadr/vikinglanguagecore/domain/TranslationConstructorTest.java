package be.stadr.vikinglanguagecore.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TranslationConstructorTest {

    @Test
    public void validTranslation(){
        Translation translation = new Translation("en", "man");

        assertEquals("en", translation.getLanguageCode());
        assertEquals("man", translation.getText());
    }

    @Test
    public void nullLanguageCode(){
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> new Translation(null, "man"));

        assertEquals(iae.getMessage(), "languageCode should not be null");
    }

    @Test
    public void nullText(){
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> new Translation("en", null));

        assertEquals(iae.getMessage(), "text should not be null");
    }
}
