package baseball.utils;

public class InputValidator {

    public static boolean isValidNumbers(String numbers) {
        if (!isLengthNumberThree(numbers)) {
            return false;
        }

        if (!isNoZeroNumber(numbers)) {
            return false;
        }

        return true;
    }

    private static boolean isLengthNumberThree(String numbers) {
        if (numbers.length() == 3) {
            return true;
        }
        return false;
    }

    private static boolean isNoZeroNumber(String numbers) {
        long correctNumberCount = numbers.chars()
                .filter(n -> Character.isDigit(n))
                .filter(n -> n != '0')
                .count();

        if (correctNumberCount == 3) {
            return true;
        }
        return false;
    }
}
