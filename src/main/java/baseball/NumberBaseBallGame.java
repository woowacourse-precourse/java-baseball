package baseball;

import baseball.player.Computer;
import baseball.player.User;
import java.util.List;

public class NumberBaseBallGame {

    private final User user;
    private final Computer computer;
    private boolean isEnd;

    public NumberBaseBallGame(User user, Computer computer) {
        this.user = user;
        this.computer = computer;
        this.isEnd = false;
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

    private int getBall(
        List<String> userSelectedBalls,
        List<String> computerSelectedBalls,
        int strike
    ) {
        int countEqualBalls = (int) userSelectedBalls.stream()
            .filter(computerSelectedBalls::contains)
            .count();
        return countEqualBalls - strike;
    }

    private boolean isEverythingRight(int strike) {
        return strike == 3;
    }
}
