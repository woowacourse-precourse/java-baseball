package controller;

public class Controller {

    public static final char MAXIMUM_RANGE = '9';
    public static final char MINIMUM_RANGE = '1';
    public static final int DIGITS = 3;

    public static boolean validateNumbers(String numbers) {
        if (!isLengthCorrect(numbers)) {
            return false;
        }
        if (!isInRange(numbers)) {
            return false;
        }
        if (!differFromEachOther(numbers)) {
            return false;
        }
        return true;
    }

    private static boolean isLengthCorrect(String str) {
        if (str.length() != DIGITS) {
            return false;
        }
        return true;
    }

    private static boolean isInRange(String str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch < MINIMUM_RANGE || MAXIMUM_RANGE < ch) {
                return false;
            }
        }
        return true;
    }

    private static boolean differFromEachOther(String str) {
        for (int i = 1; i < str.length(); i++) {
            char frontLetter = str.charAt(i - 1);
            String backString = str.substring(i);
            if (existsCharacter(frontLetter, backString)) {
                return false;
            }
        }
        return true;
    }

    private static boolean existsCharacter(char findCharacter, String str) {
        for (int i = 0; i < str.length(); i++) {
            char characterInString = str.charAt(i);
            if (compareCharacters(findCharacter, characterInString) == 0) {
                return true;
            }
        }
        return false;
    }

    private static int compareCharacters(char ch1, char ch2) {
        return (int) (ch1 - ch2);
    }

    public static void handleException(boolean result) {
        if (!result) {
            throw new IllegalArgumentException("잘못된 값을 입력하여 종료합니다.");
        }
    }
}
