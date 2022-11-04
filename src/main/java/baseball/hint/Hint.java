package baseball.hint;

import java.util.List;

public class Hint {
    static final int LENGTH = 3;
    static final String NOTHING = "낫싱";

    private int ball;
    private int strike;
    private String nothing;

    public Hint() {
    }

    public int getBall() {
        return this.ball;
    }

    public int getStrike() {
        return this.strike;
    }

    public String getNothing() {
        return this.nothing;
    }

    public void calculateBall(List<Integer> computer, List<Integer> player) {
        for (int index = 0; index < LENGTH; index++) {
            if (hasNumber(computer, player, index)) {
                this.ball++;
            }
        }
    }

    public void calculateStrike(List<Integer> computer, List<Integer> player) {
        for (int index = 0; index < LENGTH; index++) {
            if (hasNumber(computer, player, index) && isSameIndex(computer, player, index)) {
                this.strike++;
            }
        }
    }

    public void isNothing(List<Integer> computer, List<Integer> player) {
        for (int index = 0; index < LENGTH; index++) {
            if (!(hasNumber(computer, player, index))) {
                this.nothing = NOTHING;
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
}
