package baseball.controller;

import baseball.domain.Balls;
import baseball.domain.Computer;
import baseball.domain.GameStatus;
import baseball.domain.Player;
import baseball.view.InputView;
import baseball.view.OutputView;


public class BaseballGame {
    private final static int NOTHING = 0;
    private final static int OUT = 3;

    private Computer computer;
    private Player player;

    public BaseballGame() {
        computer = new Computer();
        player = new Player();
    }

    public void play() {
        OutputView.startGame();
        start();
    }

    private void start() {
        computer.generateAnswer();
        boolean isRun = true;
        while (isRun) {
            player.guessBall(InputView.getBalls());
            Balls guessBall = player.getGuessBall();
            int strike = computer.getStrike(guessBall);
            int ball = computer.getBall(guessBall);
            printResult(strike, ball);
            if (isCorrect(strike)) {
                OutputView.printFinish();
                isRun = false;
                restartOrEnd();
            }
        }
    }

    private boolean isCorrect(int strike) {
        return strike == OUT;
    }

    private void printResult(int strike, int ball) {
        if (strike == NOTHING && ball == NOTHING) {
            OutputView.printNothing();
            return;
        }
        OutputView.printStrikeAndBall(strike, ball);
    }

    private void restartOrEnd() {
        GameStatus status = GameStatus.getGameStatus(InputView.restart());
        if (status.isRestart()) {
            start();
        }
    }

}
