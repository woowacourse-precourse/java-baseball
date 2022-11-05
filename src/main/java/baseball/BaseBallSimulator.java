package baseball;

import baseball.view.BaseBallUserConsole;

import static baseball.view.BaseBallDisplay.*;

public class BaseBallSimulator {

    public void start() {
        boolean isGameEnd = true;
        printWelcomeMessage();

        while (!isGameEnd) {
            printAnswerInputMessage();
            inputAndPrintResult();
        }

        printEndMessage();
    }

    public void inputAndPrintResult() {
        boolean isMatched = false;

        while (!isMatched) {
            String input = BaseBallUserConsole.input();

            printResultMessage(0, 0);
        }
    }
}
