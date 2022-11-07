package features;


import static extract.Key.getKey;
import static features.Player.createComputerNumber;

import java.util.Map;

public class Hint {


    private static int strike = 0;
    private static int ball = 0;
    private static int nothing = 0;


    private final Map<Integer, Character> userNumber;
    private final Map<Integer, Character> computerNumber;

    // 사용자, 상대방(컴퓨터) 숫자
    public Hint(Map<Integer, Character> userNumber, Map<Integer, Character> computerNumber) {
        this.userNumber = Input.inputUserNumber();
        this.computerNumber = Player.createComputerNumber();
    }

    // 힌트 기능 동작
    public void loopHint(Map<Integer, Character> userNumber, Map<Integer, Character> computerNumber) {


        for ( int key = 0; key < computerNumber.size(); key++ ){

            Character userValue = userNumber.get(key);
            Integer userKey = getKey(userNumber, userValue);
            Character computerValue = computerNumber.get(key);
            Integer computerKey = getKey(userNumber, computerValue);

            countStrike(userValue, userKey, computerValue, computerKey);
            countBall(userValue, userKey, computerValue, computerKey);
            countNoting(userValue, userKey, computerValue, computerKey);

        }

    }

    public static void countStrike(Character userValue, Integer userKey, Character computerValue, Integer computerKey) {

        if( userValue == computerValue && userKey == computerKey){ strike++; }
    }

    // 볼 (같은 수 == 같은 수 && 같은 자리 != 같은 자리)
    public static void countBall(Character userValue, Integer userKey, Character computerValue, Integer computerKey) {

        for (int i=0; i < 3; i++) {
            if (userValue.equals(computerValue) && userKey != computerKey) {  ball++;  }
        }

    }

    // 낫싱 (같은 수 != 같은 수 && 같은 자리 != 같은 자리)
    public static void countNoting(Character userValue, Integer userKey, Character computerValue, Integer computerKey) {

        for (int i=0; i < 3; i++) {
            if (userValue != computerValue && userKey != computerKey) {  nothing++;  }
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
