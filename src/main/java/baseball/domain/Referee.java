package baseball.domain;

import java.util.List;

public class Referee {
    public String resultJudgment(List<Integer> computer, List<Integer> player) {
        NumberComparison numberComparison = new NumberComparison();
        int correctCount = numberComparison.compare(computer, player);

        int strike = 0;
        for (int i = 0; i < player.size(); i++) {
            Integer integer = player.get(i);
            if (computer.get(i) == integer) {
                strike++;
            }
        }

        if (correctCount == 0) {
            return "낫싱";
        }
        int ball = correctCount - strike;

        return getResult(strike, ball);
    }

    private String getResult(int strike, int ball) {
        if (ball >= 1 && strike == 0) {
            return ball + "볼";
        }

        if (strike >= 1 && ball == 0) {
            return strike + "스트라이크";
        }

        if (strike >= 1 && ball >= 1) {
            return ball + "볼 " + strike + "스트라이크";
        }

        return null;
    }
}
