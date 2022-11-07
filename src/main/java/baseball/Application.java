package baseball;

import baseball.gametype.BaseballType;
import baseball.input.ConsoleInput;
import baseball.output.ConsoleOutput;

public class Application {
    public static void main(String[] args) {
        new BaseballApplication(new ConsoleInput(), new ConsoleOutput()).run(BaseballType.THREE_DIGITS);
    }
}
