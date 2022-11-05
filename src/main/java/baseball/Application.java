package baseball;

import static baseball.Message.START_GAME;

public class Application {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();
        System.out.println(START_GAME);
        do {
            baseballGame.start();
        } while (baseballGame.endGame());
    }
}
