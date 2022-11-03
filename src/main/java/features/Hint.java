package features;

import static features.Input.input;
import static features.Player.createComputerNumber;

import java.util.List;
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
    private int runHint(Map<Integer, Character> playerList) {

        for (int i = 0; i < playerList.size(); i++) {
            // 스트라이크
            if (userNumber.get(i) == computerNumber.get(i)) {
                strike++;
            }

            // 볼 (같은 수 == 같은 수 && 같은 자리 != 같은 자리)
            for (int index = 0; index < 3; index++) {
                if (userNumber.get(i) == computerNumber.get(i)
                        || userNumber.getOrDefault(i,) != computerNumber.values()) {
                    ball++;
                }
            }

            // 낫싱을 세어야 하나?

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
