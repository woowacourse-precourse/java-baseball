package baseball;

import baseball.engine.BaseBallGame;
import baseball.io.ConsoleOutput;

public class Application {
    public static void main(String[] args) {
        ConsoleOutput output = new ConsoleOutput();

        new BaseBallGame(output).run();
    }
}
