package baseball.game;

import baseball.util.Validation;

import static baseball.game.View.InputValidation.validateInput;
import static baseball.util.Constant.EXCEPTION_INVALID_INPUT;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class View {
    public void show(String message) {
        System.out.print(message);
    }

    public String input() {
        String value = readLine();
        if (!validateInput(value)) {
            throw new IllegalArgumentException(EXCEPTION_INVALID_INPUT);
        }
        return value;
    }

    static class InputValidation extends Validation {
        public static boolean validateInput(String input) {
            return validateNotNull(input)
                    && validateStringNotEmpty(input)
                    && isInteger(input);
        }
    }
}
