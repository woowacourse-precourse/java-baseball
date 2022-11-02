package baseball.user;

import java.util.List;

public class UserInputValidator {

    private static final UserInputValidator instance = new UserInputValidator();

    private UserInputValidator() {}

    public UserInputValidator getInstance() {
        return instance;
    }

    public void validate(List<Integer> inputValue) {

        if (inputValue.size() != 3) {
            throw new IllegalArgumentException();
        }

        int temp = inputValue.get(0);

        for (int i = 1; i < 3; i++) {
            if (temp == inputValue.get(i)) {
                throw new IllegalArgumentException();
            } else if (temp != inputValue.get(i)) {
                temp = inputValue.get(i);
            }
        }
    }
}
