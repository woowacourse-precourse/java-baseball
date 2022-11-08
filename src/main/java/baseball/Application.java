package baseball;

import baseball.io.Input;
import baseball.io.InputImpl;
import baseball.io.Output;
import baseball.io.OutputImpl;

public class Application {

    public static void main(String[] args) throws IllegalArgumentException {

        NumberGenerator numberGenerator = new RandomsNumberGenerator();
        Input input = new InputImpl();
        Output output = new OutputImpl();
        BaseBall baseBall = new BaseBall(numberGenerator, input, output);

        output.start();
        baseBall.play();
    }
}
