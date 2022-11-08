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

    void print() {
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
            return;
        }
        if (ball != 0) {
            System.out.print(ball + "볼");
            if (strike != 0) {
                System.out.print(" ");
            }
        }
        if (strike != 0) {
            System.out.print(strike + "스트라이크");
        }
        System.out.println();
    }

    boolean strikeOut() {
        return strike == Play.getCount();
    }
}
