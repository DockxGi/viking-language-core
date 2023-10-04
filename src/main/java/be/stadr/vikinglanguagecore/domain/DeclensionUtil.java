package be.stadr.vikinglanguagecore.domain;

import be.stadr.vikinglanguagecore.domain.exception.DeclensionNotPossible;

import java.util.ArrayList;
import java.util.List;

import static be.stadr.vikinglanguagecore.domain.Case.*;
import static be.stadr.vikinglanguagecore.domain.Gender.*;
import static be.stadr.vikinglanguagecore.domain.Number.PL;
import static be.stadr.vikinglanguagecore.domain.Number.SG;

public class DeclensionUtil {

    public static List<DeclensionResult> declineNoun(Noun noun) {
        assertDeclensionPossible(noun);

        return conjugateStrongNoun(noun);
    }

    private static List<DeclensionResult> conjugateStrongNoun(Noun noun) {
        String stem = determineStem(noun);

        List<DeclensionResult> results = new ArrayList<>();
        Gender gender = noun.getGender();
        addDeclensionResults(stem, results, gender);
        addDeclensionResults(stem, results, gender);

        return results;
    }

    private static void addDeclensionResults(String stem, List<DeclensionResult> results, Gender gender) {
        Case[] theCases = Case.values();
        for (Case theCase : theCases) {
            String ending = determineStrongSgEnding(theCase, gender);
            String noun = stem + ending;
            DeclensionResult declensionResult = new DeclensionResult(theCase, SG, noun);
            results.add(declensionResult);
        }
        for (Case theCase : theCases) {
            String ending = determineStrongPlEnding(theCase, gender);
            String noun = stem + ending;
            DeclensionResult declensionResult = new DeclensionResult(theCase, PL, noun);
            results.add(declensionResult);
        }
    }

    private static String determineStrongPlEnding(Case theCase, Gender gender) {
        if (gender.equals(MALE)){
            if (theCase.equals(NOM)){
                return "ar";
            }
            if (theCase.equals(ACC)){
                return "a";
            }
            if (theCase.equals(DAT)){
                return "um";
            }
            if (theCase.equals(GEN)){
                return "a";
            }
        }
        if (gender.equals(FEMALE)){
            if (theCase.equals(NOM)){
                return "ir";
            }
            if (theCase.equals(ACC)){
                return "ir";
            }
            if (theCase.equals(DAT)){
                return "um";
            }
            if (theCase.equals(GEN)){
                return "a";
            }
        }
        if (gender.equals(NEUTER)){
            if (theCase.equals(DAT)){
                return "um";
            }
            if (theCase.equals(GEN)){
                return "a";
            }
        }
        return "";
    }

    private static String determineStrongSgEnding(Case theCase, Gender gender) {
        if (gender.equals(MALE)){
            if (theCase.equals(NOM)){
                return "r";
            }
            if (theCase.equals(DAT)){
                return "i";
            }
            if (theCase.equals(GEN)){
                return "s";
            }
        }
        if (gender.equals(FEMALE)){
            if(theCase.equals(GEN)){
                return "ar";
            }
        }
        if (gender.equals(NEUTER)){
            if (theCase.equals(DAT)){
                return "i";
            }
            if (theCase.equals(GEN)){
                return "s";
            }
        }
        return "";
    }

    private static String determineStem(Noun noun) {
        String latinNotation = noun.getLatinNotation();
        if (noun.getGender().equals(MALE)){
            return latinNotation.substring(0, latinNotation.length() - 1);
        }
        return latinNotation;
    }

    private static void assertDeclensionPossible(Noun noun) {
        Boolean strong = noun.getStrong();
        Gender gender = noun.getGender();
        if (gender == null){
            throw new DeclensionNotPossible("Declension only possible when strong property of gender is not null.");
        }
        if (strong == null) {
            throw new DeclensionNotPossible("Declension only possible when strong property of noun is not null.");
        }
        if (!strong) {
            throw new DeclensionNotPossible("Declension only supported for strong nouns");
        }
    }
}
