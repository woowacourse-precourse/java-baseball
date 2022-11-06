package baseball;

import baseball.engine.BaseBallGameEngine;
import baseball.engine.DefaultBaseBallGameEngine;
import baseball.engine.NextStepNumberGenerator;
import baseball.engine.NumberGenerator;
import baseball.io.ConsoleInput;
import baseball.io.ConsoleOutput;

public class Application {
    public static void main(String[] args) {
        ConsoleOutput output = new ConsoleOutput();
        ConsoleInput input = new ConsoleInput();
        NumberGenerator generator = new NextStepNumberGenerator();
        BaseBallGameEngine engine = new DefaultBaseBallGameEngine(generator);

        new BaseBallGame(output, input, engine).run();
    }
}
