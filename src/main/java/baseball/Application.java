package baseball;

import baseball.game.BaseballGame;
import baseball.service.GameManager;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameManager.execute(new BaseballGame());
    }
}
