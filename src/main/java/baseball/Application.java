package baseball;

import baseball.controller.Executor;

public class Application {
    public static void main(String[] args) {
        Executor executor = new Executor();
        executor.startGame();

    }
}
