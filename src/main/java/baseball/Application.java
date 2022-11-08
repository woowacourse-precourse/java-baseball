package baseball;

import baseball.game.*;
import baseball.io.Input;
import baseball.io.InputConsole;
import baseball.io.Output;
import baseball.io.OutputConsole;
import baseball.game.generator.NumberGenerator;
import baseball.game.generator.RandomNumberGenerator;

public class Application {
    public static void main(String[] args) {
        NumberGenerator generator = new RandomNumberGenerator();
        Input input = new InputConsole();
        Output output = new OutputConsole();

        new BaseBallGame(generator, input, output).run();
    }
}
