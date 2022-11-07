package baseball;

import baseball.domain.Balls;
import baseball.domain.Computer;
import baseball.domain.Player;


public class BaseballGame {
    private Computer computer;
    private Player player;

    private void getResult() {
        Balls guessBall = player.getGuessBall();
        int strike = computer.getStrike(guessBall);
        int ball = computer.getBall(guessBall);
    }

}
