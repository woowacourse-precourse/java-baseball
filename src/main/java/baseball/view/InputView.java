package baseball.view;

import baseball.util.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputNumber() {
        String inputNumber = Console.readLine();
        try {
            InputValidator.validatePlayerInputNumber(inputNumber);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        return inputNumber;
    }


    public String inputRetry() {
        String inputRetry = Console.readLine();
        try {
            InputValidator.validatePlayerInputRetry(inputRetry);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        return inputRetry;
    }
}
