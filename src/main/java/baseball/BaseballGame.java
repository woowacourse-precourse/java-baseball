package baseball;

import baseball.domain.count.ball.BallCounter;
import baseball.domain.count.strike.StrikeCounter;
import baseball.domain.number.SingleNumber;
import baseball.domain.number.randomnumber.RandomNumberFactory;
import baseball.view.print.MessagePrinter;
import baseball.view.scanner.NumberScanner;

import java.util.List;

import static baseball.domain.number.inputnumber.InputNumberFactory.newInstance;

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

    public void run() {
        List<SingleNumber> answer = RandomNumberFactory.newInstance().randomNumbers();
        int oneOrTwoForRestartGame = 0;

        messagePrinter.printStartMessage();

        while (oneOrTwoForRestartGame != 2) {
            messagePrinter.printEnterNumberMessage();

            String inputValue = numberScanner.inputNumber();
            List<SingleNumber> inputNumber = newInstance(inputValue).inputNumbers();

            int ballCount = ballCounter.checkBall(answer, inputNumber).ballCount();  // 객체화 시키는게 낫나.. 걍 int 주는게 낫나...
            int strikeCount = strikeCounter.checkStrike(answer, inputNumber).strikeCount();

            printBallAndStrikeCount(ballCount, strikeCount);

            if (strikeCount == 3) {
                messagePrinter.printCorrectAnswerMessage();
                messagePrinter.printRestartMessage();

                oneOrTwoForRestartGame = numberScanner.inputOneOrTwo();
            }

            if (oneOrTwoForRestartGame == 1) {
                answer = RandomNumberFactory.newInstance().randomNumbers();
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
