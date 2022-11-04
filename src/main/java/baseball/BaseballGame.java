package baseball;

import baseball.count.ball.BallCounter;
import baseball.count.strike.StrikeCounter;
import baseball.input.InputValueParser;
import baseball.input.NumberScanner;
import baseball.print.MessagePrinter;
import baseball.randomnumber.RandomNumberFactory;

import java.util.List;

public class BaseballGame {

    private final NumberScanner numberScanner;
    private final InputValueParser inputValueParser;
    private final BallCounter ballCounter;
    private final StrikeCounter strikeCounter;
    private final MessagePrinter messagePrinter;

    public BaseballGame(NumberScanner numberScanner, InputValueParser inputValueParser,
                        BallCounter ballCounter, StrikeCounter strikeCounter,
                        MessagePrinter messagePrinter) {
        this.numberScanner = numberScanner;
        this.inputValueParser = inputValueParser;
        this.ballCounter = ballCounter;
        this.strikeCounter = strikeCounter;
        this.messagePrinter = messagePrinter;
    }

    public void doBaseballGame() {
        List<Integer> answer = RandomNumberFactory.newRandomNumber();
        int oneOrTwoForRestartGame = 0;

        messagePrinter.printStartMessage();

        while (oneOrTwoForRestartGame != 2) {
            messagePrinter.printEnterNumberMessage();

            List<Integer> inputValue = inputValueParser.inputValueToList(
                    numberScanner.inputNumber()
            );

            int ballCount = ballCounter.checkBall(answer, inputValue).ballCount();
            int strikeCount = strikeCounter.checkStrike(answer, inputValue).strikeCount();

            printBallAndStrikeCount(ballCount, strikeCount);

            if (strikeCount == 3) {
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

    public void printBallAndStrikeCount(int ballCount, int strikeCount) {
        if (ballCount == 0 && strikeCount == 0) {
            messagePrinter.printNothing();
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();

        if (0 < ballCount) {
            stringBuilder.append(ballCount).append("볼 ");
        }

        if (0 < strikeCount) {
            stringBuilder.append(strikeCount).append("스트라이크");
        }

        messagePrinter.printBallAndStrikeCount(stringBuilder.toString());
    }
}
