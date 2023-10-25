package be.stadr.vikinglanguagecore.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class TranslationAddWordTest {

    @Test
    public void addOneWord(){
        Translation translation = new Translation("en", "we");
        Word vit = mock(Word.class);

        boolean added = translation.addWord(vit);

        assertTrue(added);
        List<Word> words = translation.getWords();
        assertEquals(1, words.size());
        assertEquals(vit, words.get(0));
    }

    @Test
    public void addSameWordTwice(){
        Translation translation = new Translation("en", "we");
        Word vit = mock(Word.class);

        boolean addedFirstTime = translation.addWord(vit);
        assertTrue(addedFirstTime);

        boolean addedSecondTime = translation.addWord(vit);
        assertFalse(addedSecondTime);

        List<Word> words = translation.getWords();
        assertEquals(1, words.size());
        assertEquals(vit, words.get(0));
    }

    @Test
    public void addTwoWords(){
        Translation translation = new Translation("en", "we");
        Word vit = mock(Word.class);
        Word ver = mock(Word.class);

        boolean added = translation.addWord(vit);
        assertTrue(added);
        boolean addedSecond = translation.addWord(ver);
        assertTrue(addedSecond);

        List<Word> words = translation.getWords();
        assertEquals(2, words.size());
        assertEquals(vit, words.get(0));
        assertEquals(ver, words.get(1));
    }
}
