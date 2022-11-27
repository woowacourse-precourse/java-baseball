package baseball.domain;

import baseball.view.InputView;
import baseball.view.OutputView;

public class Game {

    private final Referee referee;

    public Game(Referee referee) {
        this.referee = referee;
    }

    public boolean start(Player player) {
        OutputView.printStart();
        boolean isPass = referee.compareStart(player);
        OutputView.printEnd();
        return isPass;
    }

    public boolean isRestartOrEnd(boolean isPass) {
        int num = Integer.parseInt(InputView.readRestartOrEnd());

        if (num == 1) {
            return isPass;
        }

        return !isPass;
    }
}