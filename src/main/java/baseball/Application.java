package baseball;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        try {
            var created_baseball = new BaseballGame();
            created_baseball.runGame();
        } catch (IOException exception) {

        }
    }
}
