package baseball;

import java.util.List;

public class Hint {
    private Integer ball;
    private Integer strike;

    public Integer getBall() {
        return ball;
    }

    public Integer getStrike() {
        return strike;
    }

    public void getHint(List<Integer> user, List<Integer> computer) {
        this.strike = 0;
        this.ball = 0;
        getStrikeCount(user, computer);
        getBallCount(user, computer);
        this.ball -= this.strike;
    }

    private void getStrikeCount(List<Integer> user, List<Integer> computer) {
        for (int i = 0; i < ConstGame.SIZE; i++) {
            strikeCheck(user.get(i), computer.get(i));
        }
    }

    private void strikeCheck(Integer user, Integer computer) {
        if (user.equals(computer)) {
            this.strike += 1;
        }
    }

    private void getBallCount(List<Integer> user, List<Integer> computer) {
        for (Integer num : user) {
            ballCheck(num, computer);
        }
    }

    private void ballCheck(Integer userNum, List<Integer> computer) {
        if (computer.contains(userNum)) {
            this.ball += 1;
        }
    }
}
