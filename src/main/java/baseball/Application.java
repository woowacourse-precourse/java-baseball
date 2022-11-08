package baseball;

import baseball.service.GameSystem;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        GameSystem gameSystem = new GameSystem();
        gameSystem.start();
    }
}
