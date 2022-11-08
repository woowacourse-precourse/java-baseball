package baseball;

import java.util.List;

public class ResultPrinter {
    boolean isCorrect;

    public ResultPrinter() {
        isCorrect = false;
    }

    public void printResult(String input, String createdNumber) {
        final int STRIKE_INDEX = 0;
        final int BALL_INDEX = 1;
        final String BALL_STRING = "볼";
        final String STRIKE_STRING = "스트라이크";
        final String NOTHING_STRING = "낫싱";
        final String CORRECT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

        ResultValidator resultValidator = new ResultValidator();
        List<Integer> result = resultValidator.validate(input, createdNumber);
        int strike = result.get(STRIKE_INDEX);
        int ball = result.get(BALL_INDEX);
        StringBuilder stringBuilder = new StringBuilder();

        if (ball != 0) {
            stringBuilder.append(ball + BALL_STRING + " ");
        }
        if (strike != 0) {
            stringBuilder.append(strike + STRIKE_STRING + " ");
        }
        if (strike == 0 && ball == 0) {
            stringBuilder.append(NOTHING_STRING);
        }
        String resultStr = stringBuilder.toString();
        if (resultStr.endsWith(" ")) {
            resultStr = resultStr.substring(0, resultStr.length() - 1);
        }
        System.out.println(resultStr);

        if (strike == 3) {
            isCorrect = true;
            System.out.println(CORRECT_MESSAGE);
        }
    }

    public boolean isCorrect() {
        return isCorrect;
    }
}
