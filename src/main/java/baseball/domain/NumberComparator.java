package baseball.domain;

import baseball.common.Constant;

import java.util.List;


public final class NumberComparator {

    private NumberComparator() {}

    public static int getStrikeCount(List<Integer> computer, List<Integer> player) {
        int strike = 0;
        for (int i = 0; i < Constant.MAX_STRIKE_SIZE; i++) {
            if (computer.get(i).equals(player.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    public static int getBallCount(List<Integer> computer, List<Integer> player) {
        int ball = 0;
        for (int i = 0; i < Constant.MAX_STRIKE_SIZE; i++) {
            if (!computer.get(i).equals(player.get(i)) && player.contains(computer.get(i))) {
                ball++;
            }
        }
        return ball;
    }
}
