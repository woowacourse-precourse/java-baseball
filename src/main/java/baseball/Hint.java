package features;


import static extract.Constant.MAX_INDEX;
import static extract.Key.getKey;

import java.util.Map;

public class Hint {


    private static int strike = 0;
    private static int ball = 0;
    private static int nothing = 0;



    // 힌트 기능 동작
    public void loopHint(Map<Integer, Integer> userNumber, Map<Integer, Integer> computerNumber) {

        for (int key = 0; key < MAX_INDEX; key++) {

            int userValue = userNumber.get(key);
            int userKey = getKey(userNumber, userValue);
            int computerValue = computerNumber.get(key);
            int computerKey = getKey(userNumber, computerValue);

            countStrike(userValue, userKey, computerValue, computerKey);
            countBall(userValue, userKey, computerValue, computerKey);
            countNoting(userValue, userKey, computerValue, computerKey);

        }

    }

    public static void countStrike(Integer userValue, Integer userKey, Integer computerValue, Integer computerKey) {

        if (userValue == computerValue && userKey == computerKey) {
            strike++;
        }
    }

    // 볼 (같은 수 == 같은 수 && 같은 자리 != 같은 자리)
    public static void countBall(Integer userValue, Integer userKey, Integer computerValue, Integer computerKey) {

        if (userValue.equals(computerValue) && userKey != computerKey) {
            ball++;
        }


    }

    // 낫싱 (같은 수 != 같은 수 && 같은 자리 != 같은 자리)
    public static void countNoting(Integer userValue, Integer userKey, Integer computerValue, Integer computerKey) {

        if (userValue != computerValue && userKey != computerKey) {
            nothing++;
        }


    }

    public static int getCountStrike() {
        return strike;
    }

    public static int getCountBall() {
        return ball;
    }

    public static int getCountNothing() {
        return nothing;
    }

}
