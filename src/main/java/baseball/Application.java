package baseball;

import baseball.domain.count.ball.BallCounter;
import baseball.domain.count.strike.StrikeCounter;
import baseball.domain.number.inputnumber.InputNumberParser;
import baseball.view.scanner.NumberScanner;
import baseball.view.print.MessagePrinter;

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
