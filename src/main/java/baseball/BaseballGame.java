package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BaseballGame {

    private HashMap<String, Integer> answer = new HashMap<>();

    public BaseballGame(List<String> answer) {
        for (int idx = 0; idx < answer.size(); idx++) {
            this.answer.put(answer.get(idx), idx);
        }
    }

    public int countStrike(List<String> userInput) {
        int strikeCnt = 0;
        for (int idx = 0; idx < userInput.size(); idx++) {
            String separatedInput = userInput.get(idx);
            if (isSameNumber(separatedInput) && isSamePosition(separatedInput, idx)) {
                strikeCnt++;
            }
        }
        return strikeCnt;
    }

    public int countBall(List<String> userInput) {
        int BallCnt = 0;
        for (int idx = 0; idx < userInput.size(); idx++) {
            String separatedInput = userInput.get(idx);
            if (isSameNumber(separatedInput) && !isSamePosition(separatedInput, idx)) {
                BallCnt++;
            }
        }
        return BallCnt;
    }

    private boolean isSameNumber(String separatedInput) {
        boolean isSameNumber = false;
        if (answer.getOrDefault(separatedInput, -1) > 0) {
            isSameNumber = true;
        }
        return isSameNumber;
    }

    private boolean isSamePosition(String separatedInput, int position) {
        boolean isSamePosition = false;
        if (answer.get(separatedInput) == position) {
            isSamePosition = true;
        }
        return isSamePosition;
    }

    public void showResults(List<String> userInput) {
        String results = "";
        results = showBallResults(userInput, results);
        results = showStrikeResults(userInput, results);
        results = showNothingResults(userInput, results);
        System.out.println(results);
    }

    private String showNothingResults(List<String> userInput, String results) {
        if (countStrike(userInput) == 0 && countBall(userInput) == 0) {
            results += Ball.NOTHING.getName();
        }
        return results;
    }

    private String showStrikeResults(List<String> userInput, String results) {
        if (countStrike(userInput) > 0) {
            results += countStrike(userInput) + Ball.STRIKE.getName();
        }
        return results;
    }

    private String showBallResults(List<String> userInput, String results) {
        if (countBall(userInput) > 0) {
            results += countBall(userInput) + Ball.BALL.getName();
        }
        return results;
    }

    private List<String> getUserInput() {
        System.out.println(View.GAME_START_MASSAGE);
        String userInput = Console.readLine();
        raiseErrorWhenInputLengthOver3(userInput);
        List<String> inputList = convertUserInputToList(userInput);

        return inputList;
    }

    private List<String> convertUserInputToList(String userInput) {
        List<String> convertedList = new ArrayList<>();
        for (int idx = 0; idx < userInput.length(); idx++) {
            char separatedInput = userInput.charAt(idx);
            raiseErrorWhenInputIsNotDigitOrZero(separatedInput);
            convertedList.add(String.valueOf(userInput.charAt(idx)));
        }
        return convertedList;
    }

    public String playGame() {
        boolean isThreeStrike = false;

        while (!isThreeStrike) {
            List<String> userInput = getUserInput();
            showResults(userInput);
            if (countStrike(userInput) == 3) {
                isThreeStrike = true;
                break;
            }
        }
        System.out.println(View.THREE_STRIKE_MASSAGE);
        System.out.println(View.GAME_END_OR_RESTART_MASSAGE);

        return raiseErrorWhenInputIsNot1Or2();
    }

    private String raiseErrorWhenInputIsNot1Or2() throws IllegalArgumentException {
        String userInput = Console.readLine();

        try {
            if (!(userInput.equals(View.GAME_RESTART_MASSAGE) || userInput.equals(View.GAME_END_MASSAGE))) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(View.GAME_RESTART_ERROR_MASSAGE);
            return raiseErrorWhenInputIsNot1Or2();
        }
        return userInput;
    }

    private void raiseErrorWhenInputIsNotDigitOrZero(char separatedInput) {
        if (!Character.isDigit(separatedInput)) {
            throw new IllegalArgumentException(View.INPUT_IS_NOT_DIGIT_MASSAGE);
        }
        if (separatedInput == View.ZERO_INPUT_CANNOT_USE) {
            throw new IllegalArgumentException(View.INPUT_IS_ZERO_MASSAGE);
        }
    }

    private void raiseErrorWhenInputLengthOver3(String userInput) {
        if (userInput.length() > 3) {
            throw new IllegalArgumentException(View.INPUT_LENGTH_VALIDATION_MASSAGE);
        }
    }
}
