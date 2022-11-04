package baseball.util;

import baseball.domain.Game;
import camp.nextstep.edu.missionutils.Console;

public class GameManager {

    private final Game game;

    public GameManager(Game game) {
        this.game = game;
    }

    public void execute() {
        do {
            game.play();
        } while (Integer.parseInt(Console.readLine()) == 1);
    }

}
