package baseball.domain;

import baseball.domain.inputnumber.InputNumbers;
import baseball.domain.randomnumber.RandomNumberFactory;
import baseball.domain.randomnumber.RandomNumbers;
import baseball.view.print.MessagePrinter;
import baseball.view.scanner.NumberScanner;

import static baseball.domain.inputnumber.InputNumberFactory.newInstance;

public class BaseballGame {

    private final NumberScanner numberScanner;
    private final MessagePrinter messagePrinter;

    public BaseballGame(NumberScanner numberScanner, MessagePrinter messagePrinter) {
        this.numberScanner = numberScanner;
        this.messagePrinter = messagePrinter;
    }

    public void run() {
        RandomNumbers randomNumbers = RandomNumberFactory.newInstance();
        int oneOrTwoForRestartGame = 0;

        messagePrinter.printStartMessage();

        while (oneOrTwoForRestartGame != 2) {
            messagePrinter.printEnterNumberMessage();

            String inputValue = numberScanner.inputNumber();
            InputNumbers inputNumber = newInstance(inputValue);

            CountResult countResult = randomNumbers.countBallAndStrike(inputNumber);
            messagePrinter.printBallAndStrikeCount(countResult.createStringFormatOfCountResult());

            if (countResult.isThreeStrike()) {
                messagePrinter.printCorrectAnswerMessage();
                oneOrTwoForRestartGame = numberScanner.inputOneOrTwo();
            }

            if (oneOrTwoForRestartGame == 1) {
                randomNumbers = RandomNumberFactory.newInstance();
                oneOrTwoForRestartGame = 0;
            }
        }

        System.out.println("2를 입력하여, 게임이 종료되었습니다.");
    }
}
