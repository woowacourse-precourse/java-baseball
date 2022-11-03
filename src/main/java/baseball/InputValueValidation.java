package baseball;

import java.util.Arrays;
import java.util.List;

public class InputValueValidation {
    public static final int NUMBER_LENGTH = 3;
    public static final char NUMBER_MIN = '1';
    public static final char NUMBER_MAX = '9';

    public boolean isValid(String inputValue) {
        if (isNumber(inputValue) && isLengthThree(inputValue) && noDuplicates(inputValue)) {
            return true;
        }
        return false;
    }

    public boolean isNumber(String inputValue) {
        return inputValue.chars()
                .allMatch(num -> num >= NUMBER_MIN && num <= NUMBER_MAX);
    }

    public boolean isLengthThree(String inputValue) {
        return inputValue.length() == NUMBER_LENGTH;
    }

    public boolean noDuplicates(String inputValue) {
        List<String> arrayInputValue = Arrays.asList(inputValue.split(""));
        return arrayInputValue.stream().distinct().count() == NUMBER_LENGTH;
    }
}
