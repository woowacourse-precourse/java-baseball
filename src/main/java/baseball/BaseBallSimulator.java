package baseball;

import baseball.controller.BaseBallController;
import baseball.controller.dto.BaseBallDto.Response;
import baseball.view.BaseBallUserConsole;
import baseball.view.UserInputValidator;
import camp.nextstep.edu.missionutils.Console;

import static baseball.view.BaseBallDisplay.*;

public class BaseBallSimulator {

    private final BaseBallController baseBallController;

    public BaseBallSimulator() {
        this.baseBallController = new BaseBallController();
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
            String input = BaseBallUserConsole.inputAnswer();

            Response response = baseBallController.match(id, input);
            printResultMessage(response.getBall(), response.getStrike());

            isMatchedBaseBall = response.isMatch();
        }
    }

    private boolean inputReStartCondition() {
        String input = Console.readLine();
        UserInputValidator.validateReStart(input);

        return Integer.parseInt(input) == 1;
    }
}
