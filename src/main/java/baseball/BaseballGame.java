package baseball;

import baseball.domain.Balls;
import baseball.domain.Computer;
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
        boolean isFinish = false;
        while (!isFinish) {
            player.guessBall(InputView.getBalls());
            isFinish = getResult();
            if (isFinish) {
                restart();
            }
        }
    }

    private void restart() {
        int restart = InputView.restart();
        if (restart == 1) {
            play();
        }
    }

    private boolean getResult() {
        Balls guessBall = player.getGuessBall();
        int strike = computer.getStrike(guessBall);
        int ball = computer.getBall(guessBall);

        if (strike == 0 && ball == 0) {
            OutputView.printNothing();
            return false;
        }
        if (strike == 3) {
            OutputView.printResult(strike, ball);
            OutputView.printFinish();
            return true;
        }
        OutputView.printResult(strike, ball);
        return false;
    }

}
