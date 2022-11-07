package baseball.view;

import baseball.util.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputNumber() {
        String inputNumber = Console.readLine();
        InputValidator.validatePlayerInputNumber(inputNumber);

        return inputNumber;
    }


    public String inputRetry() {
        String inputRetry = Console.readLine();
        InputValidator.validatePlayerInputRetry(inputRetry);

        return inputRetry;
    }
}
