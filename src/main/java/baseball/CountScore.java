package baseball;

import java.util.List;

public class CountScore {
    int ball = 0;
    int strike = 0;

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public void compare(List computer, List user) {
        for (int idx = 0; idx < computer.size(); idx++) {
            if (computer.contains(user.get(idx))) {
                ballOrStrike(computer, user, idx);
            }
        }
    }

    public void ballOrStrike(List computer, List user, int idx) {
        if (computer.get(idx) == user.get(idx)) {
            strike++;
        } else {
            ball++;
        }
    }

}
