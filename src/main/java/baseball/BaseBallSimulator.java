package baseball;

import baseball.controller.BaseBallController;
import baseball.controller.dto.BaseBallDto.Response;
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
        Response response = baseBallController.create();

        while (!isGameEnd) {
            startProgress(response.getId());

            printProgressEndMessage();
            printReStartInputMessage();
        }

        printGameEndMessage();
    }

    private void startProgress(Long id) {
        boolean isMatchedBaseBall = false;

        while (!isMatchedBaseBall) {
            printAnswerInputMessage();
            String input = BaseBallUserConsole.inputAnswer();

            Response response = baseBallController.match(id, input);
            printResultMessage(response.getBall(), response.getStrike());

            isMatchedBaseBall = response.isMatch();
        }
    }
}
