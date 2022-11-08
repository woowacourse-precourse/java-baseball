package baseball;

import java.util.List;

public class Game {
    public int ball;
    public int strike;

    public static int strike(List<Integer> input, List<Integer> answer) {
        int strike = 0;
        for (int idx = 0; idx < User.INPUT_LENGTH; idx++) {
            if (input.get(idx) == answer.get(idx)) {
                strike++;
            }
        }
        return strike;
    }

    public static int ball(List<Integer> input, List<Integer> answer) {
        int ball = 0;
        int idx = 0;
        for (int Number : input) {
            if (answer.contains(Number) && answer.indexOf(Number) != idx) {
                ball++;
            }
            idx++;
        }
        return ball;
    }
}
