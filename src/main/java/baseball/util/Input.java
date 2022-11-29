package baseball.util;


import baseball.validation.InputValidation;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Input {

    InputValidation inputValidation = new InputValidation();

    public List<String> inputNumber() {
        String inputNumber = Console.readLine();
        inputValidation.isNumberDigit(inputNumber);
        inputValidation.isValidNumberAmount(inputNumber);
        inputValidation.isDuplicateNumber(inputNumber);
        return List.of(inputNumber.split(""));
    }

    public String inputReplayAnswer() {
        String inputCommand = Console.readLine();
        inputValidation.isValidReplayCommand(inputCommand);
        return inputCommand;
    }


}
