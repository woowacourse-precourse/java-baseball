package baseball.controller;

import baseball.domain.Balls;
import baseball.domain.Computer;
import baseball.domain.RandomNumbers;
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
        Balls comBalls = Balls.createBalls(RandomNumbers.createRandomBalls());
        referee = new Referee(new Computer(comBalls));
    }

    public void run() {
        do {
            Balls userBalls = Balls.createBalls(input.inputUserBalls());
            Output.printHint(referee.getHint(userBalls));
        } while (!referee.isEnd());
        Output.printEndMessage();
    }

}

