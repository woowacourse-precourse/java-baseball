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

    private boolean isNothing(List<String> userSelectBalls, List<String> computerSelectBalls) {
        return userSelectBalls.stream()
            .noneMatch(computerSelectBalls::contains);
    }

    private int getStrike(List<String> userSelectBalls, List<String> computerSelectBalls) {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            String userSelectBall = userSelectBalls.get(i);
            String computerSelectBall = computerSelectBalls.get(i);
            if (userSelectBall.equals(computerSelectBall)) {
                strike++;
            }
        }
        return strike;
    }
}
