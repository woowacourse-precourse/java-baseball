package baseball.Model;

import java.util.List;

public class Referee {

    private int strike;
    private int ball;
    private static final int MAX_LEN = 2;
    private static final int ZERO = 0;
    private static final String CHOICEONETWO = "[1-2]";

    public void isStrike(List<Integer> user, List<Integer> computer) {
        strike = 0;
        for (int position = MAX_LEN; position >= ZERO; position--) {
            if (user.get(position).equals(computer.get(position))) {
                strike++;
                user.remove(position);
            }
        }
    }

    public void isBall(List<Integer> user, List<Integer> computer) {
        ball = 0;
        for (Integer integer : user) {
            if (computer.contains(integer)) {
                ball++;
            }
        }
    }

    public boolean isStart(String answer) {
        if (!answer.matches(CHOICEONETWO)) {
            throw new IllegalArgumentException();
        }
        if ("2".equals(answer)) {
            return false;
        }
        return true;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
