package baseball;

import static Config.BaseResponseStatus .*;
import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
public class GamePlayer {
    private List<Integer> userNumber;
    private final ValidatorOfInputValue validatorOfInputValue;
    public GamePlayer() {
        this.userNumber = new ArrayList<>(NUMBER_LENGTH);
        this.validatorOfInputValue = new ValidatorOfInputValue();
    }

    public void setUserNumber() {
        System.out.println(NUMERIC_INPUT_MESSAGE);
        String userInput = Console.readLine();
        if (!validatorOfInputValue.checkUserInput(userInput)) {
            throw new IllegalArgumentException(INVALID_GAME_INPUT_ERROR);
        }
        userInputToUserNumber(userInput);
    }

    private void userInputToUserNumber(String userInput) {
        List<Integer> tmpUserNumber = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            tmpUserNumber.add(Character.getNumericValue(userInput.charAt(i)));
        }
        userNumber = tmpUserNumber;
    }

    public boolean checkNumberStrike(Integer idx, Integer answerNumber) {
        return userNumber.get(idx).equals(answerNumber);
    }

    public boolean checkNumberBall(Integer answerNumber) {
        return userNumber.contains(answerNumber);
    }

}
