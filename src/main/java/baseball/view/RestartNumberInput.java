package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.model.validation.Validation;

public class RestartNumberInput extends Input {
    private final Validation validation = new Validation();
    String input;

    public RestartNumberInput() {
    }

    public String inputReplayNumber() {
        input = readLine();
        validation.isValidateReplayInput(input);
        return input;
    }
}