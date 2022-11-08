package baseball.utils.validator;

import java.util.HashSet;
import java.util.regex.Pattern;

import static baseball.gameController.constant.MagicNumber.END;
import static baseball.gameController.constant.MagicNumber.RENEW;

public class InputValidator {

    public static void validateEachDigitDifferent(String input) {
        HashSet<String> set = new HashSet<>();

        for (String element : input.split("")) {
            set.add(element);
        }

        if (input.length() != set.size()) throw new IllegalArgumentException();
    }

    public static void validateEachDigitBetween1And9(String input) {
        for (String element : input.split("")) {
            if (Pattern.matches("[^1-9]", element)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateIs3DigitNumber(String input) {
        if (input.length() != 3) throw new IllegalArgumentException();
    }

    public static void validateChoiceCode(String input) {
        if (input.equals(RENEW) || input.equals(END)) return;

        throw new IllegalArgumentException();
    }
}
