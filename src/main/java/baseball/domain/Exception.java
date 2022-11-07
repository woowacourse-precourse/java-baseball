package baseball.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exception {

    public static void throwException(String message) {
        throw new IllegalArgumentException(message);
    }

    public static void checkNumberFormatException(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throwException(Constants.NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }

    public static void checkNumberRangeException(String number) {
        Pattern pattern = Pattern.compile(Constants.RANGE_FORMAT_PATTERN);
        Matcher matcher = pattern.matcher(number);
        if (!matcher.matches()) {
            throwException(Constants.NUMBER_RANGE_ERROR_MESSAGE);
        }
    }

    public static void checkNumberLengthException(String number) {
        if (number.length() != Constants.NUMBER_LENGTH) {
            throwException(Constants.NUMBER_LENGTH_ERROR_MESSAGE);
        }
    }

    public static void checkRepeatedNumberException(String number) {
        Pattern pattern = Pattern.compile(Constants.REPEATED_PATTERN);
        Matcher matcher = pattern.matcher(number);
        if (matcher.find()) {
            throwException(Constants.REPEATED_NUMBER_ERROR_MESSAGE);
        }
    }

    public static void checkChoiceException(String choice) {
        if (!(choice.equals(Constants.RESTART) || choice.equals(Constants.QUIT))) {
            throwException(Constants.CHOICE_ERROR_MESSAGE);
        }
    }
}
