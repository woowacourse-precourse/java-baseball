package baseball;

import baseball.io.Input;
import baseball.io.InputImpl;
import baseball.io.Output;
import baseball.io.OutputImpl;

public class Application {
    private static final int RESTART = 1;
    private static final int EXIT = 2;

    public static void main(String[] args) throws IllegalArgumentException {

        NumberGenerator numberGenerator = new RandomsNumberGenerator();
        Input input = new InputImpl();
        Output output = new OutputImpl();
        BaseBall baseBall = new BaseBall(numberGenerator, input, output);

        output.start();
        do {
            baseBall.play();
            output.end();
        } while (Boolean.TRUE.equals(isRestart(input)));
    }

    private static Boolean isRestart(Input input) throws IllegalArgumentException {
        String inputString = input.input("");

        if (inputString.length() != 1) throw new IllegalArgumentException();
        if (!Character.isDigit(inputString.charAt(0))) throw new IllegalArgumentException();
        int restartStatus = Integer.parseInt(inputString);
        if (restartStatus != RESTART && restartStatus != EXIT) throw new IllegalArgumentException();

        return restartStatus == RESTART;
    }
}
