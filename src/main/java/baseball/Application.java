package baseball;

import baseball.constants.SystemConsole;
import baseball.domain.GameResultScore;

public class Application {

    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame(new SystemConsole(), new GameResultScore());
        baseballGame.start();
    }
}