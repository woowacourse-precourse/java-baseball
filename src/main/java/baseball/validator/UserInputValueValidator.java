package baseball.validator;

import java.util.List;

public class UserInputValueValidator {
    private static final UserInputValueValidator USER_INPUT_VALUE_VALIDATOR = new UserInputValueValidator();

    public static UserInputValueValidator getInstance() {
        return USER_INPUT_VALUE_VALIDATOR;
    }

    private UserInputValueValidator() {
    }

    public void validate(List<String> inputValue) {
        if (inputValue.stream()
                .distinct()
                .filter(element -> element.charAt(0) > 48)
                .filter(element -> element.charAt(0) < 58)
                .count() != 3) {
            throw new IllegalArgumentException();
        }
    }
}
