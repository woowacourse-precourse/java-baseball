package baseball;

import baseball.domain.Baseball;
import baseball.domain.Game;
import baseball.domain.GameManager;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new Baseball();
        GameManager gameManager = new GameManager(game);
        gameManager.execute();
    }
}
