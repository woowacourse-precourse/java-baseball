package baseball.domain;

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
