package baseball.view;

import static baseball.view.BaseballGameConstant.INPUT_NUMBER_ERROR_MESSAGE;
import static baseball.view.BaseballGameConstant.INPUT_NUMBER_MESSAGE;

import baseball.domain.BaseballNumber;
import baseball.exception.InvalidInputException;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGameInputView {
    public static BaseballNumber getPlayerNumber(){
        System.out.print(INPUT_NUMBER_MESSAGE);
        String playerNumber = Console.readLine();
        if(!BaseballGameInputValidator.validate(playerNumber)){
            throw new InvalidInputException(INPUT_NUMBER_ERROR_MESSAGE);
        }
        return new BaseballNumber(playerNumber);
    }
}
