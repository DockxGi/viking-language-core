package be.stadr.vikinglanguagecore.domain;


import be.stadr.vikinglanguagecore.domain.exception.ConjugationNotPossible;

import java.util.ArrayList;
import java.util.List;

import static be.stadr.vikinglanguagecore.domain.Number.PL;
import static be.stadr.vikinglanguagecore.domain.Number.SG;

public class ConjugationUtil {
    public static List<ConjugationResult> conjugateVerb(Verb verb) {
        assertConjugationPossible(verb);

        return conjugateWeakVerb(verb);
    }

    private static List<ConjugationResult> conjugateWeakVerb(Verb verb) {
        Integer conjugation = verb.getConjugation();
        String latinNotation = verb.getLatinNotation();

        String sgStem = determineStem(latinNotation, conjugation, SG);
        String plSem = determineStem(latinNotation, conjugation, PL);

        List<ConjugationResult> results = new ArrayList<>(6);
        for (int person = 1; person < 4; person++) {
            ConjugationResult cr = new ConjugationResult();
            cr.setSubject(determineSubject(person, SG));
            //todo
        }

        return null;
    }

    public static String determineStem(String latinNotation, int conjugation, Number num) {
        String stem = latinNotation.substring(0, latinNotation.length() - 1);

        if (num.equals(Number.PL) || conjugation == 3){
            return stem;
        }

        Character stemFinalVowel = null;
        if (conjugation == 1){
            stemFinalVowel = 'a';
        } else if (conjugation == 2 || conjugation == 4){
            stemFinalVowel = 'i';
        }

        return stem + stemFinalVowel;
    }

    public static String determineSubject(int person, Number num){
        if (num.equals(SG)){
            switch (person){
                case 1: return "ek";
                case 2: return "þú";
                case 3: return "hann/hon/þat";
            }
        }
        return switch (person) {
            case 1 -> "vér/vit";
            case 2 -> "þér/þit";
            case 3 -> "þeir/þær/þau";
            default -> null;
        };
    }

    private static void assertConjugationPossible(Verb verb) {
        if (verb.getStrong() == null || verb.getStrong()){
            throw new ConjugationNotPossible("Conjugation only supported for weak verbs.");
        }
        if (verb.getConjugation() == null){
            throw new ConjugationNotPossible("Conjugation only possible if conjugation property (number) is not null.");
        }
    }
}
