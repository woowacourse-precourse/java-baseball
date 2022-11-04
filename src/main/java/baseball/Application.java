package baseball;

import baseball.count.BallAndStrikeCounter;
import baseball.input.NumberScanner;
import baseball.print.MessagePrinter;

public class Application {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame(
                new NumberScanner(),
                new BallAndStrikeCounter(),
                new MessagePrinter()
        );

        baseballGame.doBaseballGame();
    }
}
