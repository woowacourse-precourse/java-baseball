package baseball.domain;

import baseball.view.Input;
import java.util.ArrayList;

public class Player {
    private final static Input input = new Input();

    public int chooseRestartOrExit() {
        return input.readPlayerChoice();
    }

    public ArrayList<Integer> guessNumbers() {
        return input.readPlayerGuess();
    }
}
