package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.List;

import static baseball.InGameMessage.*;

public class BaseballGameManager {
    private List<Integer> baseballNumberList;
    private ElementListMaker<Integer> elementListMaker;
    private UserInputTimer inputTimer;
    private int numberCount;

    public BaseballGameManager(List<Integer> baseballNumberList, ElementListMaker<Integer> elementListMaker) {
        this.baseballNumberList = baseballNumberList;
        this.elementListMaker = elementListMaker;
        this.numberCount = baseballNumberList.size();
    }

    public void executeGame() {
        boolean isAllStrikes = false;
        while (!isAllStrikes) {
            System.out.println(BASEBALL_GAME_GET_USER_INPUT_MESSAGE.getMessage());

            String userInput = this.getValidInput();
            List<Integer> userInputElementList = elementListMaker.convertToElementList(userInput);

            BaseballScore baseballScore = this.calculateBaseballScore(userInputElementList);
            this.printBaseballScore(baseballScore);

            if (baseballScore.getStrikeCount() == numberCount) {
                isAllStrikes = true;
            }
        }
        // close Game Set
        return;
    }

    private String getValidInput() {
        inputTimer = new UserInputTimer();
        inputTimer.setTimer();
        String userInput = Console.readLine();
        inputTimer.closeTimer();

        if (userInput.length() != numberCount) {
            throw new NumberFormatException();
        }

        /* 예외 상황 try catch
        try {
            // userInput이 Integer로 타입 변환이 가능한지 (숫자가 아닌 값 입력시 예외처리)
            Integer.parseInt(userInput);

            // userInput이 정해진 갯수의 숫자가 입력되지 않은 경우
            if (userInput.length() != numberCount) {
                throw new NumberFormatException();
            }

            // userInput에 중복되는 숫자가 있는 경우
            if (hasDuplicateNumberElement(userInput)) {
                throw new NumberFormatException();
            }

        } catch (NumberFormatException numberFormatException) {
            System.out.printf(BASEBALL_GAME_ASK_FOR_DIVIDED_NUMBER_MESSAGE.getMessage(), numberCount);
            getValidInput();
        }
        */
        return userInput;
    }

    public BaseballScore calculateBaseballScore(List<Integer> inputNumberList) {
        int ballCount = 0;
        int strikeCount = 0;

        for (int inputNumber : inputNumberList) {

            int indexInOriginalList = inputNumberList.indexOf(inputNumber);
            int indexInBaseballNumberList = baseballNumberList.indexOf(inputNumber);

            // baseballNumberList에 inputNumber의 element가 없는 경우
            if (indexInBaseballNumberList == -1) {
                continue;
            }
            if (indexInOriginalList == indexInBaseballNumberList) {
                strikeCount++;
            }
            if (indexInOriginalList != indexInBaseballNumberList) {
                ballCount++;
            }
        }

        return new BaseballScore(ballCount, strikeCount);
    }

    public void printBaseballScore(BaseballScore baseballScore) {
        if (baseballScore.getBallCount() > 0) {
            if (baseballScore.getStrikeCount() > 0) {
                System.out.printf(BASEBALL_GAME_RESULT_BALL_STRIKE.getMessage(), baseballScore.getBallCount(), baseballScore.getStrikeCount());
            } else {
                System.out.printf(BASEBALL_GAME_RESULT_BALL.getMessage(),baseballScore.getBallCount());
            }
            return;
        }

        if (baseballScore.getStrikeCount() > 0) {
            System.out.printf(BASEBALL_GAME_RESULT_STRIKE.getMessage(), baseballScore.getStrikeCount());
            return;
        }

        System.out.println(BASEBALL_GAME_RESULT_NOTHING.getMessage());
    }

    private boolean hasDuplicateNumberElement(String userInput) {
        int userInputSetSize = new HashSet<>(elementListMaker.convertToElementList(userInput)).size();

        if (userInputSetSize < numberCount) {
            return true;
        }

        return false;
    }
}
