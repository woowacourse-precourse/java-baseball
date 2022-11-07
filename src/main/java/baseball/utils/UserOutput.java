package baseball.utils;

import static baseball.utils.BaseballConstants.*;

public class UserOutput {

    public static void printResult(int ball, int strike){
        String result = "";

        if (ball != 0) {
            result += ball + BALL;
        }
        if (strike != 0) {
            result += " " + strike + STRIKE;
        }
        if (result.length() == 0) {
            result = NOTHING;
        }

        System.out.println(result.strip());
        if (strike == BALL_NUMBER){
            System.out.println(GAME_OVER);
        }
    }
}
