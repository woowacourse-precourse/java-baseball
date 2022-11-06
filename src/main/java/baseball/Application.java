package baseball;

import baseball.domain.BaseballGame;
import baseball.view.print.MessagePrinter;
import baseball.view.scanner.NumberScanner;

public class Application {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame(
                new NumberScanner(),
                new MessagePrinter()
        );

        baseballGame.run();
    }
}
