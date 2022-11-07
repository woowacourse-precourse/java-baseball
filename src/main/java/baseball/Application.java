package baseball;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();
        try {
            baseballGame.playGame();
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }
}
