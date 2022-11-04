package features;

import static extract.Key.getKey;
import static features.Input.input;
import static features.Player.createComputerNumber;

import java.util.Map;

public class Hint {


    private static int strike;
    private static int ball;
    private static int nothing;

    public void hint() {
        this.strike = 0;
        this.ball = 0;
    }

    // 사용자 숫자
    static Map<Integer, Character> userNumber = input();
    // 상대방(컴퓨터) 숫자
    static Map<Integer, Character> computerNumber = createComputerNumber();

    // 힌트 기능 동작
    public void runHint(Map<Integer, Character> playerNumber) {

        Character userValue0 = userNumber.get(0);
        Character userValue1 = userNumber.get(1);
        Character userValue2 = userNumber.get(2);

        Character computerValue0 = computerNumber.get(0);
        Character computerValue1 = computerNumber.get(1);
        Character computerValue2 = computerNumber.get(2);

        Integer userKey0 = getKey(userNumber, userValue0);
        Integer userKey1 = getKey(userNumber, userValue1);
        Integer userKey2 = getKey(userNumber, userValue2);

        Integer computerKey0 = getKey(computerNumber, computerValue0);
        Integer computerKey1 = getKey(computerNumber, computerValue1);
        Integer computerKe2 = getKey(computerNumber, computerValue2);

        for (key = 0; key < playerNumber.size(); key++){
            // 스트라이크 (같은 수 == 같은 수 && 같은 자리 == 같은 자리)
            if (userValue == computerValue && userKey == computerKey) {
                strike++;
            }

            // 볼 (같은 수 == 같은 수 && 같은 자리 != 같은 자리)
            if (userValue == computerValue && userKey != computerKey) {
                ball++;
            }

            // 낫싱 (같은 수 != 같은 수 && 같은 자리 != 같은 자리)
            if (userValue != computerValue && userKey != computerKey) {
                nothing++;
            }
        }

    }

    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return this.ball;
    }

    public int getNothing() {
        return this.nothing;
    }
}
