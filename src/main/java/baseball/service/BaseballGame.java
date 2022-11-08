package baseball.service;

import static baseball.service.StartOptions.RESTART;
import static baseball.service.StartOptions.START;
import static baseball.service.StartOptions.STOP;

import baseball.domain.game_number.Answer;
import baseball.domain.game_number.CountResult;
import baseball.domain.game_number.Guess;
import baseball.view.print.MessagePrinter;
import baseball.view.scanner.NumberScanner;

public final class BaseballGame {

    private final NumberScanner numberScanner;
    private final MessagePrinter messagePrinter;

    public BaseballGame(NumberScanner numberScanner, MessagePrinter messagePrinter) {
        this.numberScanner = numberScanner;
        this.messagePrinter = messagePrinter;
    }

    public void start() {
        Answer answer = new Answer();
        StartOptions sign = START;

        messagePrinter.printStartMessage();

        while (!sign.is(STOP)) {
            messagePrinter.printEnterNumberMessage();

            String inputNumber = numberScanner.inputNumber();
            Guess guess = new Guess(inputNumber);

            CountResult countResult = answer.ballAndStrikeCount(guess);
            messagePrinter.printBallAndStrikeCount(countResult.stringFormatOfCountResult());

            if (countResult.withThreeStrike()) {
                messagePrinter.printCorrectAnswerMessage();
                String oneOrTwo = numberScanner.inputOneOrTwo();
                sign = StartOptions.of(oneOrTwo);
            }

            if (sign.is(RESTART)) {
                answer = new Answer();
                sign = START;
            }
        }

        System.out.println("2를 입력하여, 게임이 종료되었습니다.");
    }
}
