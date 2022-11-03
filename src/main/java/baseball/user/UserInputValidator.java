package baseball.user;

import java.util.List;

public class UserInputValidator {

    public UserInputValidator() {}

    public void validate(List<String> inputValue) {

        if (inputValue.size() != 3 || inputValue.contains("0")) {
            throw new IllegalArgumentException();
        }

        String temp = inputValue.get(0);

        for (int i = 0; i < 2; i++) {
            if (temp.charAt(0) < 47 || temp.charAt(0) > 58) {
                throw new IllegalArgumentException();
            } else if (temp.equals(inputValue.get(i + 1))) {
                throw new IllegalArgumentException();
            } else if (!temp.equals(inputValue.get(i + 1))) {
                temp = inputValue.get(i);
            }
        }
    }
}
