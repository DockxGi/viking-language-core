package be.stadr.vikinglanguagecore.domain;

import liquibase.repackaged.org.apache.commons.collections4.IterableUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.apache.commons.lang3.RandomUtils.nextInt;

public abstract class RandomWordsPicker {

    public static Iterable<Word> pickRandomFrom(Iterable<Word> wordsToPickFrom, int amount) {
        List<Word> words = IterableUtils.toList(wordsToPickFrom);
        Set<Word> pickedWords = new HashSet<>();

        for (int i = 0; i < amount; i++){
            int amountToPickFrom = words.size();
            int indexToPick = nextInt(0, amountToPickFrom);

            Word pickedWord = words.get(indexToPick);
            pickedWords.add(pickedWord);
            words.remove(pickedWord);
        }

        return pickedWords;
    }
}
