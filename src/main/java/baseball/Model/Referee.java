package baseball.Model;

import java.util.List;

public class Referee {

    private static final int MAX_LEN = 2;
    private static final int ZERO = 0;
    public static final String CHOICEONETWO = "[1-2]";

    public int isStrike(List<Integer> user, List<Integer> computer) {
        int strike = 0;
        for (int position = MAX_LEN; position >= ZERO; position--) {
            if (user.get(position).equals(computer.get(position))) {
                strike++;
                user.remove(position);
            }
        }
        return strike;
    }

    public int isBall(List<Integer> user, List<Integer> computer) {
        int ball = 0;
        for (Integer integer : user) {
            if (computer.contains(integer)) {
                ball++;
            }
        }
        return ball;
    }

    public boolean isStart(String answer) {
        if ("2".equals(answer)) {
            return false;
        }
        return true;
    }
}
