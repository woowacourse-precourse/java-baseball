package baseball.view.input;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.model.validation.Validation;

public class PlayerNumberInput extends Input {
    private final Validation validation = new Validation();
    String input;

    public PlayerNumberInput() {
    }

    public String inputPlayerNumber() {
        input = readLine();
        validation.isValidateInput(input);
        return input;
    }
}