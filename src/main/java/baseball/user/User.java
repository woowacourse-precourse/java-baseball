package baseball.user;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final UserInputValidator userInputValidator;

    public User(UserInputValidator userInputValidator) {
        this.userInputValidator = userInputValidator;
    }

    public List<String> inputNumber() {
        List<String> inputValue = new ArrayList<>();

        while (inputValue.size() < 3) {
            inputValue.add(Console.readLine());
        }

        userInputValidator.validate(inputValue);
        return inputValue;
    }
}
