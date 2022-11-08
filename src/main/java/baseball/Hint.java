package baseball;


import static baseball.Constant.MAX_INDEX;
import static baseball.Key.getKey;

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
    public static void loopHint(Map<Integer, Integer> userNumber, Map<Integer, Integer> computerNumber) {
        for (int key = 0; key < MAX_INDEX; key++) {

            int userValue = userNumber.get(key);
            int userKey = getKey(userNumber, userValue);
            int computerValue = computerNumber.get(key);
            int computerKey = getKey(computerNumber, computerValue);

            countStrike(userValue, userKey, computerValue, computerKey);
            countBall(userValue, userKey, computerValue, computerKey);


        }
    }

    public static int countStrike(Integer userValue, Integer userKey, Integer computerValue, Integer computerKey) {

        if (userValue == computerValue && userKey == computerKey) {
            strike++;
        }
        return strike;
    }

    // 볼 (같은 수 == 같은 수 && 같은 자리 != 같은 자리)
    public static int countBall(Integer userValue, Integer userKey, Integer computerValue, Integer computerKey) {

        if ( userKey != computerKey && userValue == computerValue ) {
            ball++;
        }

        return ball;


    }




}
