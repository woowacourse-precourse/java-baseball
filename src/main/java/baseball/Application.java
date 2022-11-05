package baseball;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        BaseballGame created_baseball = new BaseballGame();
        created_baseball.runGame();
    }
}
