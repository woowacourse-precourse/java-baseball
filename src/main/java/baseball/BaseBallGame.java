package baseball;

import java.util.List;

public class BaseBallGame {
    private static final String START_GAME = "숫자 야구 게임을 시작합니다.";

    public BaseBallGame() {
    }

    public void startGame() {
        System.out.println(START_GAME);
        repeatGame();
    }
}
