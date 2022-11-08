package baseball.view;

import baseball.model.Balls;
import baseball.model.Result;

public class OutputView {

    private static final String INIT_SIGN = "숫자 야구 게임을 시작합니다.";

    public static void init() {
        System.out.println(INIT_SIGN);
    }

    public static void print(Result result) {
        if (result.hasBall()) {
            System.out.printf("%d볼 ", result.getBall());
        }
        if (result.hasStrike()) {
            System.out.printf("%d스트라이크", result.getStrike());
        }
        if (result.isNothing()) {
            System.out.print("낫싱");
        }
        System.out.println();
        if (result.isGameEnd()) {
            System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n", Balls.NUMBER_OF_BALLS);
        }
    }
}
