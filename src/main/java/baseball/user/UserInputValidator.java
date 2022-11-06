package baseball.user;

import java.util.List;
import java.util.stream.Stream;

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
                .filter(element -> element.charAt(0) < 49)
                .filter(element -> element.charAt(0) > 57)
                .count() != 3) {
            throw new IllegalArgumentException();
        }
    }
}
