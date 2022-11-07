package baseball;

import java.util.List;

public class ResultPrinter {

    public void printResult(String input, String createdNumber) {
        final int STRIKE_INDEX = 0;
        final int BALL_INDEX = 1;
        final String BALL_STRING = "볼";
        final String STRIKE_STRING = "스트라이크";
        final String NOTHING_STRING = "낫싱";

        ResultValidator resultValidator = new ResultValidator();
        List<Integer> result = resultValidator.validate(input, createdNumber);
        int strike = result.get(STRIKE_INDEX);
        int ball = result.get(BALL_INDEX);
        if (ball != 0) {
            System.out.println(ball + BALL_STRING);
        }
        if (strike != 0) {
            System.out.println(strike + STRIKE_STRING);
        }
        if (strike == 0 && ball == 0) {
            System.out.println(NOTHING_STRING);
        }
    }
}
