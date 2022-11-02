package baseball;

import baseball.engine.BaseBallGame;
import baseball.io.ConsoleInput;
import baseball.io.ConsoleOutput;

public class Application {
    public static void main(String[] args) {
        ConsoleOutput output = new ConsoleOutput();
        ConsoleInput input = new ConsoleInput();

        new BaseBallGame(output, input).run();
    }
}
