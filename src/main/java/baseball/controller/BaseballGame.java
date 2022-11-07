package baseball.controller;

import baseball.domain.Balls;
import baseball.domain.Computer;
import baseball.domain.GameStatus;
import baseball.domain.Player;
import baseball.view.InputView;
import baseball.view.OutputView;


public class BaseballGame {
    private Computer computer;
    private Player player;

    public BaseballGame() {
        computer = new Computer();
        player = new Player();
    }

    public void play() {
        OutputView.startGame();
        computer.generateAnswer();
        boolean isRun = true;
        while (isRun) {
            player.guessBall(InputView.getBalls());
            int result = getResult();
            if (result == 3) {
                OutputView.printFinish();
                isRun = false;
                restart();
            }
        }
    }

    private void restart() {
        GameStatus status = GameStatus.getGameStatus(InputView.restart());
        if (status.isRestart()) {
            play();
        }
    }

    private int getResult() {
        Balls guessBall = player.getGuessBall();
        int strike = computer.getStrike(guessBall);
        int ball = computer.getBall(guessBall);
        if (strike == 0 && ball == 0) {
            OutputView.printNothing();
        }
        OutputView.printResult(strike, ball);
        return strike;
    }

}
