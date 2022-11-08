package baseball;


import static baseball.Constant.MAX_INDEX;

import java.util.Map;

public class Hint {

    public static int strike;
    public static int ball;



    public static int getStrike() {
        return strike;
    }

    public static int getBall() {
        return ball;
    }


    // 힌트 기능 동작
    public static Hint loopHint(Map<Integer, Integer> userNumber, Map<Integer, Integer> computerNumber) {
        for (int key = 0; key < MAX_INDEX; key++) {

            int userValue = userNumber.get(key);
            int computerValue = computerNumber.get(key);

            countStrike(userValue, computerValue);
            countBall(computerNumber, userValue);
        }

        return new Hint();
    }



    public static int countStrike(Integer userValue, Integer computerValue) {

        if (userValue.equals(computerValue)) {
            strike++;
        }
        return strike;
    }

    public static int countBall(Map<Integer, Integer> computerNumber, int userValue) {
        if (computerNumber.containsValue(userValue)) {
            ball++;
        }
        return ball;
    }
}
