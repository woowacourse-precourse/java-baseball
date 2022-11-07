package baseball;

import java.util.List;

enum Score {
    GAME;

    private int ball;
    private int strike;

    Score() {
        resetScore();
    }

    private void resetScore() {
        ball = 0;
        strike = 0;
    }

    void getScore(List<Integer> computer, List<Integer> user) {
        resetScore();
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
