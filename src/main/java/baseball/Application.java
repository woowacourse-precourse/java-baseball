package baseball;

import baseball.numbers.RandomNumbersGenerationStrategy;
import baseball.game.BaseballGame;

public class Application {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame(new RandomNumbersGenerationStrategy());
        baseballGame.start();
    }
}
