package baseball.util;


import baseball.validation.InputValidation;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Input {

    InputValidation inputValidation = new InputValidation();

    public List<String> inputNumber() {
        String input = Console.readLine();
        inputValidation.isNumberDigit(input);
        inputValidation.isValidNumberAmount(input);
        inputValidation.isDuplicateNumber(input);
        return List.of(input.split(""));
    }

    public String inputReplayAnswer() {
        String inputCommand = Console.readLine();
        inputValidation.isValidReplayCommand(inputCommand);
        return inputCommand;
    }


}
