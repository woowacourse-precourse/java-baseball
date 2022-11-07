package baseball.utils;

import baseball.model.Ball;

import java.util.List;

public class StrikeBallUtil {

    public static Ball findStrikeAndBall(String user, List<Integer> computer) {
        int strike = 0, ball = 0;

        for (int i = 0; i < 3; i++) {
            int num = user.charAt(i) - '0';

            int idx = computer.indexOf(num);

            if (idx == i) {
                strike++;
            } else if (idx != -1) {
                ball++;
            }
        }

        return new Ball(ball, strike);
    }
}
