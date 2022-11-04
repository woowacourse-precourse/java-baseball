package baseball;

import baseball.domain.count.ball.BallCounter;
import baseball.domain.count.strike.StrikeCounter;
import baseball.view.print.MessagePrinter;
import baseball.view.scanner.NumberScanner;

import java.util.List;

import static baseball.domain.number.inputnumber.InputNumberParser.parseInputNumber;
import static baseball.domain.number.randomnumber.RandomNumberFactory.newRandomNumber;

public class BaseballGame {

    private final NumberScanner numberScanner;
    private final BallCounter ballCounter;
    private final StrikeCounter strikeCounter;
    private final MessagePrinter messagePrinter;

    public BaseballGame(NumberScanner numberScanner,
                        BallCounter ballCounter,
                        StrikeCounter strikeCounter,
                        MessagePrinter messagePrinter) {
        this.numberScanner = numberScanner;
        this.ballCounter = ballCounter;
        this.strikeCounter = strikeCounter;
        this.messagePrinter = messagePrinter;
    }

    public void doBaseballGame() {
        List<Integer> answer = newRandomNumber().answer();
        int oneOrTwoForRestartGame = 0;

        messagePrinter.printStartMessage();

        while (oneOrTwoForRestartGame != 2) {
            messagePrinter.printEnterNumberMessage();

            String inputValue = numberScanner.inputNumber();
            List<Integer> inputNumber = parseInputNumber(inputValue).inputNumbers();

            int ballCount = ballCounter.checkBall(answer, inputNumber).ballCount();
            int strikeCount = strikeCounter.checkStrike(answer, inputNumber).strikeCount();

            printBallAndStrikeCount(ballCount, strikeCount);

            if (strikeCount == 3) {
                messagePrinter.printCorrectAnswerMessage();
                messagePrinter.printRestartMessage();

                oneOrTwoForRestartGame = numberScanner.inputOneOrTwo();
            }

            if (oneOrTwoForRestartGame == 1) {
                answer = newRandomNumber().answer();
                oneOrTwoForRestartGame = 0;
            }
        }

        System.out.println("2를 입력하여, 게임이 종료되었습니다.");
    }

    private void printBallAndStrikeCount(int ballCount, int strikeCount) {
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
