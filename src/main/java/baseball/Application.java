package baseball;

import baseball.input.InputReader;

public class Application {
    public static void main(String[] args) {
        GameManager manager = new GameManager(
                new Computer(),
                new Player(),
                new InputReader()
        );

        manager.run();
    }
}
