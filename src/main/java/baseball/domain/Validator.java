package baseball.domain;

import static baseball.constant.Constants.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static void validateInput(String input) {
        checkNumberFormatException(input);
        checkNumberLengthException(input);
        checkNumberRangeException(input);
        checkRepeatedNumberException(input);
    }

    public static void validateChoice(String input) {
        checkNumberFormatException(input);
        checkChoiceException(input);
    }

    public static void checkNumberFormatException(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throwException(NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }

    public static void checkNumberRangeException(String number) {
        Pattern pattern = Pattern.compile(RANGE_FORMAT_PATTERN);
        Matcher matcher = pattern.matcher(number);
        if (!matcher.matches()) {
            throwException(NUMBER_RANGE_ERROR_MESSAGE);
        }
    }

    public static void checkNumberLengthException(String number) {
        if (number.length() != NUMBER_LENGTH) {
            throwException(NUMBER_LENGTH_ERROR_MESSAGE);
        }
    }

    public static void checkRepeatedNumberException(String number) {
        Pattern pattern = Pattern.compile(REPEATED_PATTERN);
        Matcher matcher = pattern.matcher(number);
        if (matcher.find()) {
            throwException(REPEATED_NUMBER_ERROR_MESSAGE);
        }
    }

    public static void checkChoiceException(String choice) {
        if (!(choice.equals(RESTART) || choice.equals(QUIT))) {
            throwException(CHOICE_ERROR_MESSAGE);
        }
    }

    public static void throwException(String message) {
        throw new IllegalArgumentException(message);
    }
}
