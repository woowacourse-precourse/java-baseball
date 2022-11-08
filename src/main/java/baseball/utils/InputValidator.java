package baseball.utils;

public class InputValidator {
    private static final int MAX_LENGTH = 3;

    public static boolean isValidNumbers(String numbers) {
        if (!isLengthNumberThree(numbers)) {
            return false;
        }

        if (!isNoZeroNumber(numbers)) {
            return false;
        }

        if (!isUnique(numbers)) {
            return false;
        }

        return true;
    }

    private static boolean isLengthNumberThree(String numbers) {
        if (numbers.length() == MAX_LENGTH) {
            return true;
        }
        return false;
    }

    private static boolean isNoZeroNumber(String numbers) {
        long correctNumberCount = numbers.chars()
                .filter(n -> Character.isDigit(n))
                .filter(n -> n != '0')
                .count();

        if (correctNumberCount == MAX_LENGTH) {
            return true;
        }
        return false;
    }

    private static boolean isUnique(String numbers) {
        for (int i = 0; i < numbers.length(); i++) {
            if (!(numbers.indexOf(numbers.charAt(i)) == i)) {
                return false;
            }
        }
        return true;
    }
}
