package baseball;

import java.util.List;

enum Score {
    SCORE;

    private int ball;
    private int strike;

    Score() {
        reset();
    }

    private void reset() {
        ball = 0;
        strike = 0;
    }

    void of(List<Integer> user, List<Integer> computer) {
        reset();
        for (int digit : user) {
            if (!computer.contains(digit)) {
                continue;
            }
            if (user.indexOf(digit) == computer.indexOf(digit)) {
                strike++;
                continue;
            }
            ball++;
        }
    }
}
