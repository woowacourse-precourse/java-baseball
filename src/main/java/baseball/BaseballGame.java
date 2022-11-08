package baseball;

import baseball.domain.game_number.CountResult;
import baseball.domain.game_number.Guess;
import baseball.domain.game_number.Answer;
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
        int oneOrTwoForRestartGame = 0;

        messagePrinter.printStartMessage();

        while (oneOrTwoForRestartGame != 2) {  // 0은 게임 진행 중, 1은 게임 재시작, 2는 게임 끝... 의미 전달을 잘 할순 없을까?
            messagePrinter.printEnterNumberMessage();

            String inputNumber = numberScanner.inputNumber();
            Guess guess = new Guess(inputNumber);

            CountResult countResult = answer.ballAndStrikeCount(guess);
            messagePrinter.printBallAndStrikeCount(countResult.stringFormatOfCountResult());

            if (countResult.withThreeStrike()) {
                messagePrinter.printCorrectAnswerMessage();
                oneOrTwoForRestartGame = numberScanner.inputOneOrTwo();
            }

            if (oneOrTwoForRestartGame == 1) {
                answer = new Answer();
                oneOrTwoForRestartGame = 0;
            }
        }

        System.out.println("2를 입력하여, 게임이 종료되었습니다.");
    }
}
