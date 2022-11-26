package baseball.domain;

import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class Game {

    private Computer computer;
    private Player player;
    private Referee referee;

    public Game(Computer computer, Player player, Referee referee) {
        this.computer = computer;
        this.player = player;
        this.referee = referee;
    }

    public boolean start() {
        OutputView.printStart();
        List<Integer> computerNumbers = computer.generateNumber();

        boolean pass = referee.isPass();
        while (!pass) {
            List<Integer> playerNumbers = player.selectNumbers(InputView.readNumbers());
            referee.compareTo(computerNumbers, playerNumbers);
            pass = referee.isPass();
        }

        OutputView.printEnd();
        return true;
    }

    public boolean isRestartOrEnd(boolean isPass) {
        int num = Integer.parseInt(InputView.readRestartOrEnd());

        if (num == 1) {
            return !isPass;
        }

        return isPass;
    }
}