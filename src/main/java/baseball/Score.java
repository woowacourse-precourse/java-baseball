package baseball;

import java.util.List;

public class Score {
    private int strike;
    private int ball;

    private static int getStrikeCount(List<Integer> computerNumber, List<Integer> userNumber) {
        int strike = 0;
        for (int index = 0; index < 3; index++) {
            if (computerNumber.get(index) == userNumber.get(index)) {
                strike++;
            }
        }

        return strike;
    }

    private static int getBallCount(List<Integer> computerNumber, List<Integer> userNumber) {
        int strike = 0;
        int ball = 0;
        for (int index = 0; index<3; index++){
            if (computerNumber.get(index) == userNumber.get(index)) {
                strike++;
            }
            if (computerNumber.contains(userNumber.get(index))) {
                ball++;
            }
        }

        if (strike>0) {
            ball -= strike;
        }

        return ball;
    }

}
