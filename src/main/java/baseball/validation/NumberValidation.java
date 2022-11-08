package baseball.validation;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static baseball.util.GameCode.*;
import static baseball.util.RegexCode.*;

public class NumberValidation {

    public NumberValidation() {

    }

    public void validateUserInput(String input) {
        validateIsNumber(input);
        validateLength(input);
        validateDuplicate(input);
    }

    public void validateRandomAnswer(List<Integer> input) {
        StringBuilder builder = new StringBuilder();
        input.forEach(builder::append);
        String result = builder.toString();

        validateLength(result);
        validateDuplicate(result);
    }

    public void validateLength(String input) {
        if (input.length() != VALID_NUMBER_LENGTH.getCode()) {
            throw new IllegalArgumentException("number length must be 3");
        }
    }

    public void validateIsNumber(String input) {
        Pattern pattern = Pattern.compile(REGEX_NOT_NUMBER.getRegex());
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            throw new IllegalArgumentException("input value must be number");
        }
    }

    public void validateDuplicate(String input) {
        Pattern pattern = Pattern.compile(REGEX_HAS_DUPLICATE_VALUE.getRegex());
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            throw new IllegalArgumentException("number must not be duplicated");
        }
    }
}
