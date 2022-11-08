package baseball.model;

import baseball.view.Input;

public class PlayerNumber {
    private static Input input = new Input();

    public static String continueGame() {
        return input.inputExit();
    }
}
