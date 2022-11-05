package baseball;

import baseball.domain.count.ball.BallCounter;
import baseball.domain.count.strike.StrikeCounter;
import baseball.view.print.MessagePrinter;
import baseball.view.scanner.NumberScanner;

public class Application {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame(
                new NumberScanner(),
                new BallCounter(),
                new StrikeCounter(),
                new MessagePrinter()
        );

        baseballGame.run();
    }
}
