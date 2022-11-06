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
        if (inputValue.size() != 3 || inputValue.contains("0")) {
            throw new IllegalArgumentException();
        }

        for (int index = 0; index < 2; index++) {
            String currentlyExploredValue = inputValue.get(index);
            if (currentlyExploredValue.charAt(0) < 47 ||
                    currentlyExploredValue.charAt(0) > 58 ||
                    currentlyExploredValue.equals(inputValue.get(index + 1))) {
                throw new IllegalArgumentException();
            }
        }
    }
}
