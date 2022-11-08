package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BaseballGame {
    private final HashMap<String, Integer> answer = new HashMap<>();

    public BaseballGame(List<String> answer) {
        for (int idx = 0; idx < answer.size(); idx++) {
            this.answer.put(answer.get(idx), idx);
        }
    }

    public void playGame() {
        while (true) {
            List<String> userInput = getUserInput();
            showResult(userInput);
            if (countStrike(userInput) == View.MAX_BALL_LENGTH) {
                break;
            }
        }
        View.showThreeStrikeMessage();
        View.showGameEndOrRestartMessage();
    }

    private List<String> getUserInput() {
        View.showGameStartMessage();
        String userInput = Console.readLine();
        View.raiseErrorWhenInputLengthOverThree(userInput);
        List<String> inputList = convertUserInputToList(userInput);
        View.raiseErrorIfInputContainsSameNumber(inputList);
        return inputList;
    }



    private List<String> convertUserInputToList(String userInput) {
        List<String> convertedList = new ArrayList<>();
        for (int idx = 0; idx < userInput.length(); idx++) {
            char separatedInput = userInput.charAt(idx);
            View.raiseErrorWhenInputIsNotDigitOrZero(separatedInput);
            convertedList.add(String.valueOf(userInput.charAt(idx)));
        }

        return convertedList;
    }

    public void showResult(List<String> userInput) {
        String result = "";
        result += countBallResult(userInput);
        result += countStrikeResult(userInput);
        result += addNothingResult(userInput);
        System.out.println(result);
    }

    private String countBallResult(List<String> userInput) {
        String ballResult = "";
        if (countBall(userInput) > 0) {
            ballResult += countBall(userInput) + Ball.BALL.getName();
        }
        return ballResult;
    }

    private String countStrikeResult(List<String> userInput) {
        String strikeResult = "";
        if (countStrike(userInput) > 0) {
            strikeResult += countStrike(userInput) + Ball.STRIKE.getName();
        }
        return strikeResult;
    }

    private String addNothingResult(List<String> userInput) {
        String nothingResult = "";
        if (countStrike(userInput) == 0 && countBall(userInput) == 0) {
            nothingResult += Ball.NOTHING.getName();
        }
        return nothingResult;
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
        return answer.getOrDefault(separatedInput, -1) >= 0;
    }

    private boolean isSamePosition(String separatedInput, int position) {
        return answer.get(separatedInput) == position;
    }
}
