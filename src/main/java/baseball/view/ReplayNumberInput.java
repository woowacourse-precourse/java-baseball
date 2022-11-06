package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.gamenumber.Validation;

public class ReplayNumberInput extends Input {
    private final Validation validation = new Validation();
    String input;

    public ReplayNumberInput() {
    }

    public String inputReplayNumber() {
        input = readLine();
        validation.isValidateReplayInput(input);
        return input;
    }
}
