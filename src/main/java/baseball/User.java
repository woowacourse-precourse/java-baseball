package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    final static int INPUT_LOWER_BOUND = 100;
    final static int INPUT_UPPER_BOUND = 999;
    final static int REPLAY_INPUT_TRUE = 1;
    final static int REPLAY_INPUT_FALSE = 2;
    List<Integer> userInputList = new ArrayList<>();

    public User() {
    }

    public List<Integer> getUserInputList() {
        return userInputList;
    }

    private void convertGuessInputToList(String userInput) {
        userInputList.clear();
        for (int i = 0; i < userInput.length(); i++) {
            char eachCharInput = userInput.charAt(i);
            int eachIntInput = Character.getNumericValue(eachCharInput);
            userInputList.add(eachIntInput);
        }
    }

    /**
     * 사용자의 서로 다른 3자리의 수 입력을 받아 검증 후 userInputList 에 저장하는 메소드
     */
    public void getUserGuessInput() {
        String userInput = camp.nextstep.edu.missionutils.Console.readLine();
        if (validateUserGuessInput(userInput)) {
            convertGuessInputToList(userInput);
        }
    }

    /**
     * 사용자의 서로 다른 3자리의 수 입력을 검증하는 메소드
     */
    public boolean validateUserGuessInput(String userInput) {
        try {
            int userInt = Integer.parseInt(userInput);
            int userIntLength = String.valueOf(userInt).length();
            if (userIntLength != 3 || userInt < INPUT_LOWER_BOUND || userInt > INPUT_UPPER_BOUND || isDuplicatedInput(
                    userInput)) {
                throw new NumberFormatException();
            }
            return true;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isDuplicatedInput(String userInput) {
        char firstNumber = userInput.charAt(0);
        char secondNumber = userInput.charAt(1);
        char thirdNumber = userInput.charAt(2);
        return firstNumber == secondNumber || secondNumber == thirdNumber || firstNumber == thirdNumber;
    }

    private boolean checkUserReplayInput(String userInput) {
        return Objects.equals(userInput, "1");
    }

    /**
     * 게임 재시작에 대한 사용자 입력을 받아 boolean 값을 리턴하는 메소드
     */
    public boolean getUserReplayInput() {
        String userInput = Console.readLine();
        if (validateUserReplayInput(userInput)) {
            return checkUserReplayInput(userInput);
        }
        return false;
    }

    private boolean validateUserReplayInput(String userInput) {
        try {
            int userInt = Integer.parseInt(userInput);
            int userIntLength = String.valueOf(userInt).length();
            if (userIntLength != 1 || (userInt != REPLAY_INPUT_TRUE && userInt != REPLAY_INPUT_FALSE)) {
                throw new NumberFormatException();
            }
            return true;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
