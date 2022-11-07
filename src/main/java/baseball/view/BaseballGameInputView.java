package baseball.view;

import static baseball.view.BaseballGameConstant.INPUT_NUMBER_MESSAGE;

import baseball.domain.BaseballNumber;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGameInputView {
    public static BaseballNumber getPlayerNumber(){
        System.out.print(INPUT_NUMBER_MESSAGE);
        String playerNumber = Console.readLine();
        return new BaseballNumber(playerNumber);
    }
}
