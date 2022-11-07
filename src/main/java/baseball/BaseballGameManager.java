package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BaseballGameManager {
    private static final String BASEBALL_GAME_GET_USER_INPUT_MESSAGE = "숫자를 입력하세요.";

    private List<Integer> baseballNumberList;
    private ElementListMaker<Integer> elementListMaker;

    public BaseballGameManager(List<Integer> baseballNumberList, ElementListMaker<Integer> elementListMaker) {
        this.baseballNumberList = baseballNumberList;
        this.elementListMaker = elementListMaker;
    }

    public void executeGame() {
        boolean is3Strikes = false;
        while (!is3Strikes) {
            System.out.println(BASEBALL_GAME_GET_USER_INPUT_MESSAGE);

            String userInput = this.getValidInput();
            List<Integer> userInputElementList = elementListMaker.convertToElementList(userInput);

            BaseballScore baseballScore = this.calculateBaseballScore(userInputElementList);
            this.printBaseballScore(baseballScore);

            if (baseballScore.getStrikeCount() == 3) {
                is3Strikes = true;
            }

        }
    }

    private String getValidInput() {
        String userInput = null;
        boolean isInputValid = false;

        while (!isInputValid) {
            userInput = Console.readLine();

            try {
                if (userInput.length() != baseballNumberList.size()) {
                    throw new IllegalArgumentException();
                }

                isInputValid = true;
            } catch (IllegalArgumentException illegalArgumentException) {
                System.err.println("※서로 다른 숫자 3개를 입력해주세요.※");
            }
        }

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
        StringBuilder scoreString = new StringBuilder();

        if (baseballScore.getBallCount() > 0) {
            scoreString.append(baseballScore.getBallCount());
            scoreString.append("볼 ");
        }

        if (baseballScore.getStrikeCount() > 0) {
            scoreString.append(baseballScore.getStrikeCount());
            scoreString.append("스트라이크");
        }

        if (scoreString.toString().length() == 0) {
            scoreString.append("낫싱");
        }

        System.out.println(scoreString.toString().trim());
    }
}
