package baseball;

import baseball.gametype.BaseballType;
import device.input.ConsoleInput;
import device.output.ConsoleOutput;

public class Application {
    public static void main(String[] args) {
        new BaseballApplication(new ConsoleInput(), new ConsoleOutput()).run(BaseballType.THREE_DIGITS);
    }
}
