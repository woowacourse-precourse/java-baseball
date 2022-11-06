package baseball.Model;

import java.util.List;

public class Referee {

    private static final int MAX_LEN = 2;
    private static final int ZERO = 0;

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
}
