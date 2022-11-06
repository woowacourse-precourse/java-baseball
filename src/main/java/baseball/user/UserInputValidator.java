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
        if (inputValue.size() != 3 || inputValue.contains("0")) {
            throw new IllegalArgumentException();
        }
        else if (inputValue.stream().distinct().count() != 3) {
            throw new IllegalArgumentException();
        }

        for (int index = 0; index < 3; index++) {
            String currentlyExploredValue = inputValue.get(index);
            if (currentlyExploredValue.charAt(0) < 47 ||
                    currentlyExploredValue.charAt(0) > 58) {
                throw new IllegalArgumentException();
            }
        }


    }
}
