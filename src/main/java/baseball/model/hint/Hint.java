package baseball.model.hint;

import java.util.List;

public class Hint {
    static final int NUMBER_DIGITS = 3;

    private int ball = 0;
    private int strike = 0;

    public Hint() {
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public void calculateBall(List<Integer> computer, List<Integer> player) {
        for (int index = 0; index < NUMBER_DIGITS; index++) {
            if (hasNumber(computer, player, index) && !isSameIndex(computer, player, index)) {
                ball += 1;
            }
        }
    }

    public void calculateStrike(List<Integer> computer, List<Integer> player) {
        for (int index = 0; index < NUMBER_DIGITS; index++) {
            if (hasNumber(computer, player, index) && isSameIndex(computer, player, index)) {
                strike += 1;
            }
        }
    }

    public boolean isSameIndex(List<Integer> computer, List<Integer> player, int index) {
        if (computer.get(index).equals(player.get(index))) {
            return true;
        }
        return false;
    }

    public boolean hasNumber(List<Integer> computer, List<Integer> player, int index) {
        if (computer.contains(player.get(index))) {
            return true;
        }
        return false;
    }

    public boolean isEndGame() {
        if (getStrike() == NUMBER_DIGITS) {
            return true;
        }
        return false;
    }
}