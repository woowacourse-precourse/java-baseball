package baseball.domain;

import baseball.view.Input;

import java.util.ArrayList;

public class Player {
    private final static Input input = new Input();
    private final static int RESTART = 1;

    private int wantNewGameOrExit = RESTART;

    public void chooseRestartOrExit() {
        wantNewGameOrExit =  input.readPlayerChoice();
    }

    public boolean wantNewGame() {
        return wantNewGameOrExit == RESTART;
    }

    public ArrayList<Integer> guessNumbers() {
        return input.readPlayerGuess();
    }
}
