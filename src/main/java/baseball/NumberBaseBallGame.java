package baseball;

import baseball.player.Computer;
import baseball.player.User;
import java.util.List;

public class NumberBaseBallGame {

    private final User user;
    private final Computer computer;

    public NumberBaseBallGame(User user, Computer computer) {
        this.user = user;
        this.computer = computer;
    }

    private void selectBalls() {
        user.selectBalls();
        computer.selectBalls();
    }

    private boolean isNothing(List<String> userSelectedBalls, List<String> computerSelectedBalls) {
        return userSelectedBalls.stream()
            .noneMatch(computerSelectedBalls::contains);
    }
}
