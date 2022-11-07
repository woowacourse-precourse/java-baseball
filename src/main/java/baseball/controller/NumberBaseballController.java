package baseball.controller;

import baseball.validation.UserInputValidator;
import camp.nextstep.edu.missionutils.Console;

public class NumberBaseballController {

    private final UserInputValidator validator;

    public NumberBaseballController(UserInputValidator validator) {
        this.validator = validator;
    }

    public int readUserInput() {
        String input = Console.readLine();

        validator.validateGuessInput(input);

        return Integer.parseInt(input);
    }

    //guessAnswer()
}
