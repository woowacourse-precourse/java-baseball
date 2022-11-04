package baseball;

import baseball.count.ball.BallCounter;
import baseball.count.strike.StrikeCounter;
import baseball.number.inputnumber.InputNumberParser;
import baseball.scanner.NumberScanner;
import baseball.print.MessagePrinter;

public class Application {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame(
                new NumberScanner(),
                new InputNumberParser(),
                new BallCounter(),
                new StrikeCounter(),
                new MessagePrinter()
        );

        baseballGame.doBaseballGame();
    }
}
