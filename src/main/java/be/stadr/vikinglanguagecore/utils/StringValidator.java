package be.stadr.vikinglanguagecore.utils;

public class StringValidator {


    /**
     * Validates that the string has exactly the given length.
     * Throws IllegalArgumentException if the string has another length.
     * @param string
     * @param length
     * @param message
     */
    public static void length(String string, int length, String message){
        if (string.length() != length){
            throw new IllegalArgumentException(message);
        }
    }
}
