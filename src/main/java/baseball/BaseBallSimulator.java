package baseball;

import baseball.controller.BaseBallController;
import baseball.controller.dto.BaseBallDto.Response;
import baseball.view.BaseBallUserConsole;
import baseball.view.UserInputValidator;
import camp.nextstep.edu.missionutils.Console;

import static baseball.view.BaseBallDisplay.*;

public class BaseBallSimulator {

    private final BaseBallController baseBallController;
    private final BaseBallUserConsole baseBallUserConsole;

    public BaseBallSimulator() {
        this.baseBallController = new BaseBallController();
        this.baseBallUserConsole = new BaseBallUserConsole();
    }

    public void start() {
        boolean isGameEnd = false;
        printWelcomeMessage();
        Response response = baseBallController.create();

        while (!isGameEnd) {
            startProgress(response.getId());

            printProgressEndMessage();

            printReStartInputMessage();
            isGameEnd = !inputReStartCondition();
        }

        printGameEndMessage();
    }

    private void startProgress(Long id) {
        boolean isMatchedBaseBall = false;

        while (!isMatchedBaseBall) {
            printAnswerInputMessage();
            String input = baseBallUserConsole.inputAnswer();

            Response response = baseBallController.match(id, input);
            printResultMessage(response.getBall(), response.getStrike());

            isMatchedBaseBall = response.isMatch();
        }
    }

    private boolean inputReStartCondition() {
        String input = baseBallUserConsole.inputReStart();

        return Integer.parseInt(input) == 1;
    }
}
