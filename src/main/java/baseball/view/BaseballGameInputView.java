package baseball.view;

import static baseball.view.BaseballGameConstant.GAME_FINISHED_MESSAGE;
import static baseball.view.BaseballGameConstant.INPUT_NUMBER_ERROR_MESSAGE;
import static baseball.view.BaseballGameConstant.INPUT_NUMBER_MESSAGE;
import static baseball.view.BaseballGameConstant.RESTART_NUMBER_ERROR_MESSAGE;

import baseball.domain.BaseballNumber;
import baseball.exception.InvalidInputException;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGameInputView {
    public static BaseballNumber getPlayerNumber() {
        System.out.print(INPUT_NUMBER_MESSAGE);
        String playerNumber = Console.readLine();
        if (!BaseballGameInputValidator.validatePlayerNumber(playerNumber)) {
            throw new InvalidInputException(INPUT_NUMBER_ERROR_MESSAGE);
        }
        return new BaseballNumber(playerNumber);
    }

    public static boolean selectReplay() {
        System.out.println(GAME_FINISHED_MESSAGE);
        String input = Console.readLine();
        if (!BaseballGameInputValidator.validateReplayNumber(input)) {
            throw new InvalidInputException(RESTART_NUMBER_ERROR_MESSAGE);
        }
        return input.equals("1");
    }
}
