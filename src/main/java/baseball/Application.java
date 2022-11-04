package baseball;

import baseball.count.ball.BallCounter;
import baseball.count.strike.StrikeCounter;
import baseball.input.InputValueParser;
import baseball.input.NumberScanner;
import baseball.print.MessagePrinter;

public class Application {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame(
                new NumberScanner(),
                new InputValueParser(),
                new BallCounter(),
                new StrikeCounter(),
                new MessagePrinter()
        );

        baseballGame.doBaseballGame();
    }
}
