package baseball.user;

import java.util.List;

public class UserInputValidator {
    private static final UserInputValidator userInputValidator = new UserInputValidator();

    public static UserInputValidator getInstance() {
        return userInputValidator;
    }

    private UserInputValidator() {
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
