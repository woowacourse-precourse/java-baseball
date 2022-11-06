package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.model.gamenumber.Validation;

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
