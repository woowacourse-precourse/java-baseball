package baseball.user;

import java.util.List;

public class UserInputValidator {

    private static final UserInputValidator instance = new UserInputValidator();

    private UserInputValidator() {}

    public static UserInputValidator getInstance() {
        return instance;
    }

    public void validate(List<String> inputValue) {

        if (inputValue.size() != 3) {
            throw new IllegalArgumentException();
        }

        String temp = inputValue.get(0);

        for (int i = 1; i < 3; i++) {
            if (temp.equals(inputValue.get(i))) {
                throw new IllegalArgumentException();
            } else if (!temp.equals(inputValue.get(i))) {
                temp = inputValue.get(i);
            }
        }
    }
}
