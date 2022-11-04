package baseball;

import baseball.domain.BaseBall;
import baseball.domain.Game;
import baseball.util.GameManager;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new BaseBall();
        GameManager gameManager = new GameManager(game);
        gameManager.execute();
    }
}
