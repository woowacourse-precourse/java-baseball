package baseball;

import baseball.constants.SystemConsole;
import baseball.domain.GameResultScore;
import baseball.domain.RandomGenerator;

public class Application {

    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame(new RandomGenerator(), new SystemConsole(), new GameResultScore());
        baseballGame.start();
    }
}