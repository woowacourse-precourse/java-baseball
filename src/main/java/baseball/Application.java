package baseball;

import baseball.io.Output;
import baseball.io.OutputImpl;

public class Application {

    public static void main(String[] args) throws IllegalArgumentException {

        NumberGenerator numberGenerator = new RandomsNumberGenerator();
        Output output = new OutputImpl();
        BaseBall baseBall = new BaseBall(numberGenerator, output);

        output.start();
        baseBall.play();
    }
}
