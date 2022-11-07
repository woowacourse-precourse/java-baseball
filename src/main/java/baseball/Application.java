package baseball;

import java.time.LocalDateTime;

public class Application {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        BaseBallGame bg = new BaseBallGame();
        bg.run();
    }
}
