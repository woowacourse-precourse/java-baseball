package baseball;

import java.util.HashSet;

public class UserInputException extends Exception {
    public static void lengthCheck(String strIn) throws IllegalArgumentException {
        if (strIn.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    public static void numberCheck(String strIn) throws IllegalArgumentException {
        if (strIn.split("[1-9]").length > 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void duplicateCheck(String strIn) throws IllegalArgumentException {
        HashSet<Integer> duplicateCheckSet = new HashSet<>();
        for (int i = 0; i < strIn.length(); i++) {
            duplicateCheckSet.add(strIn.charAt(i)-'0');
        }
        if (duplicateCheckSet.size() != 3) {
            throw new IllegalArgumentException();
        }
    }
}
