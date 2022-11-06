package baseball;

import baseball.controller.BaseBallController;
import baseball.view.BaseBallUserConsole;

import static baseball.view.BaseBallDisplay.*;

public class BaseBallSimulator {

    private final BaseBallController baseBallController;

    public BaseBallSimulator() {
        this.baseBallController = new BaseBallController();
    }

    public void start() {
        boolean isGameEnd = true;
        printWelcomeMessage();
        baseBallController.create();

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
