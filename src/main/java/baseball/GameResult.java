package baseball;

import java.util.List;

public class GameResult {

    private int strike;
    private int ball;

    public GameResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public void setGameResult(List<Integer> answers, List<Integer> inputs) {
        for (int i = 0; i < 3; i++) {
            if (answers.get(i).equals(inputs.get(i))) {
                strike++;
            } else if (answers.contains(inputs.get(i))) {
                ball++;
            }
        }
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }

    public boolean isThreeStrike() {
        return strike == 3;
    }

    public String getResult() {
        if (isNothing()) {
            return "낫싱";
        }
        if (isThreeStrike()) {
            return "3스트라이크\n" + "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        }
        if (strike == 0) {
            return ball + "볼";
        }
        if (ball == 0) {
            return strike + "스트라이크";
        }
        return ball + "볼 " + strike + "스트라이크";
    }
}
