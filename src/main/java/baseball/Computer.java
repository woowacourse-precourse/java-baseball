package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Computer {
    class GameResult {
        int strike;
        int ball;

        GameResult(int strike, int ball) {
            this.strike = strike;
            this.ball = ball;
        }

        boolean isNothing() {
            return strike == 0 && ball == 0;
        }

        @Override
        public String toString() {
            if (isNothing()) {
                return "낫싱";
            }
            List<String> result = new ArrayList<>();
            if (ball != 0) {
                result.add(String.format("%d볼", ball));
            }
            if (strike != 0) {
                result.add(String.format("%d스트라이크", strike));
            }
            return String.join(" ", result);
        }
    }

    List<Integer> targetNumber;

    public List<Integer> pickTargetNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        targetNumber = computer;
        return computer;
    }

    public GameResult compare(List<Integer> userNumber) {
        int strike = getStrike(userNumber);
        int ball = getBall(userNumber);
        return new GameResult(strike, ball);
    }

    private int getStrike(List<Integer> userNumber) {
        int strike = 0;
        for (int i = 0; i < targetNumber.size(); i++) {
            if (Objects.equals(userNumber.get(i), targetNumber.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    private int getBall(List<Integer> userNumber) {
        int ball = 0;
        for (int i = 0; i < targetNumber.size(); i++) {
            if (Objects.equals(userNumber.get(i), targetNumber.get(i))) {
                continue;
            }
            if (targetNumber.contains(userNumber.get(i))) {
                ball++;
            }
        }
        return ball;
    }
}
