package baseball;

import baseball.count.BallAndStrikeCounter;
import baseball.input.NumberScanner;
import baseball.print.MessagePrinter;
import baseball.randomnumber.RandomNumberFactory;

import java.util.List;
import java.util.Map;

public class BaseballGame {
    private static final String STRIKE_KEY = "strike";

    private final NumberScanner numberScanner;
    private final BallAndStrikeCounter ballAndStrikeCounter;
    private final MessagePrinter messagePrinter;

    public BaseballGame(NumberScanner numberScanner,
                        BallAndStrikeCounter ballAndStrikeCounter,
                        MessagePrinter messagePrinter) {
        this.numberScanner = numberScanner;
        this.ballAndStrikeCounter = ballAndStrikeCounter;
        this.messagePrinter = messagePrinter;
    }

    public void doBaseballGame() {
        List<Integer> answer = RandomNumberFactory.newRandomNumber();
        int oneOrTwoForRestartGame = 0;

        messagePrinter.printStartMessage();

        while (oneOrTwoForRestartGame != 2) {
            messagePrinter.printEnterNumberMessage();

            String inputValue = numberScanner.inputNumber();  // 객체화. -> BallList -> List<Ball>
            Map<String, Integer> ballAndStrikeCount = ballAndStrikeCounter
                    .checkBallAndStrikeCount(answer, inputValue);  // ball이랑 strike를 나눈다.

            messagePrinter.printBallAndStrikeCount(ballAndStrikeCount);

            if (ballAndStrikeCount.get(STRIKE_KEY) == 3) {
                messagePrinter.printCorrectAnswerMessage();
                messagePrinter.printRestartMessage();

                oneOrTwoForRestartGame = numberScanner.inputOneOrTwo();
            }

            if (oneOrTwoForRestartGame == 1) {
                answer = RandomNumberFactory.newRandomNumber();
                oneOrTwoForRestartGame = 0;
            }
        }

        System.out.println("2를 입력하여, 게임이 종료되었습니다.");
    }
}
