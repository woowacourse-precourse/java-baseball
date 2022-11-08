package baseball.view;

import static baseball.controller.BaseballGameController.NUM_LENGTH;

public class GameHost {
    public static void startPrint() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void successPrint() {
        System.out.println(NUM_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
