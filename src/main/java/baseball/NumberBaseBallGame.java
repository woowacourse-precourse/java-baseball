package baseball;

import baseball.player.Computer;
import baseball.player.User;

public class NumberBaseBallGame {

    private final User user;
    private final Computer computer;

    public NumberBaseBallGame(User user, Computer computer) {
        this.user = user;
        this.computer = computer;
    }
}
