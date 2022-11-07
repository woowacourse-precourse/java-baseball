package baseball.view;

import static baseball.model.Constant.END_INPUT_EMPTY_STRING;
import static baseball.model.Constant.END_INPUT_INVALID_END_TYPE;
import static baseball.model.Constant.END_INPUT_INVALID_NUMBER_SIZE;
import static baseball.model.Constant.END_INPUT_NOT_NUMBER;
import static baseball.model.Constant.END_INPUT_TYPE_END;
import static baseball.model.Constant.END_INPUT_TYPE_RESTART;
import static baseball.model.Constant.GAME_END;
import static baseball.model.Constant.GAME_USER_INPUT;
import static baseball.model.Constant.RESTART_OR_END;
import static baseball.model.Constant.START_BASEBALL_GAME;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGameView {
    public void startBaseballGame() {
        System.out.println(START_BASEBALL_GAME);
    }

    public String getUserInput() {
        System.out.printf(GAME_USER_INPUT);
        String userBaseballInput = Console.readLine();
        return userBaseballInput;
    }

    public void printUserInputHint(String userInputResult) {
        System.out.println(userInputResult);
    }

    public int endBaseballGame() {
        System.out.println(GAME_END);
        System.out.println(RESTART_OR_END);
        String endGameInput = Console.readLine();
        validateEndGameInput(endGameInput);
        validateNumberString(endGameInput);
        int endGameType = Integer.parseInt(endGameInput);
        return endGameType;
    }

    public void validateEndGameInput(String endGameInput) {
        if (endGameInput.isBlank()) {
            throw new IllegalArgumentException(END_INPUT_EMPTY_STRING);
        }

    }

    public boolean isNumberString(String uncheckedString) {
        for (int i = 0; i < uncheckedString.length(); i++) {
            char uncheckedCharacter = uncheckedString.charAt(i);
            if(!Character.isDigit(uncheckedCharacter)) {
                return false;
            }
        }
        return true;
    }

    public void validateNumberString(String endGameInput) {
        if (!isNumberString(endGameInput)) {
            throw new IllegalArgumentException(END_INPUT_NOT_NUMBER);
        }
        if(endGameInput.length() > 1) {
            throw new IllegalArgumentException(END_INPUT_INVALID_NUMBER_SIZE);
        }
        if(!endGameInput.equals(END_INPUT_TYPE_RESTART) && !endGameInput.equals(END_INPUT_TYPE_END)) {
            throw new IllegalArgumentException(END_INPUT_INVALID_END_TYPE);
        }
    }
}
