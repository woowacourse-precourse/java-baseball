package baseball;

import static baseball.utils.ErrorMessages.*;

public class StringToIntegerConvertor {
    public static int convert(String input) {
        int convertedNumber;
        try {
            convertedNumber = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(CONVERT_STRING_TO_INTEGER_FAIL);
        }
        return convertedNumber;
    }
}
