package baseball.controller;

import baseball.validation.UserInputValidator;
import camp.nextstep.edu.missionutils.Console;

public class NumberBaseballController {

    private final UserInputValidator validator;

    public NumberBaseballController(UserInputValidator validator) {
        this.validator = validator;
    }

    private int readUserInput() {
        String input = Console.readLine();

        validator.validateGuessInput(input);

        return Integer.parseInt(input);
    }

    private int readRestartInput() {
        String input = Console.readLine();

        validator.validateRestartInput(input);

        return Integer.parseInt(input);
    }
}
