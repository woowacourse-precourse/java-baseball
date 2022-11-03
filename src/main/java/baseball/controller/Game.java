package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.RandomBalls;
import baseball.domain.Referee;
import baseball.view.Input;
import baseball.view.Output;

public class Game {

    private final Input input;
    private Referee referee;

    public Game() {
        this.input = new Input();
    }

    public void setGame() {
        Output.printStartGameMessage();
        referee = new Referee(new Computer(RandomBalls.createRandomBalls()));
    }

    public void run() {
        do {
            Output.printHint(referee.getHint(input.inputUserBalls()));
        } while (!referee.isEnd());
        Output.printEndMessage();
    }

}

