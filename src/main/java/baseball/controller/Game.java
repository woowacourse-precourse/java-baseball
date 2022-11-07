package baseball.controller;

import baseball.domain.Balls;
import baseball.util.RandomNumbers;
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
        referee = new Referee(Balls.createBalls(RandomNumbers.createRandomNumbers()));
    }

    public void run() {
        do {
            Balls userBalls = Balls.createBalls(input.inputUserBalls());
            Output.printHint(referee.judgeScore(userBalls));
        } while (!referee.isEnd());
        Output.printEndMessage();
    }

    public boolean reGame() {
        return input.inputReGameButton();
    }
}