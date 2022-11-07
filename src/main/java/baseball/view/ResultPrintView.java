package baseball.view;

import baseball.domain.model.Result;
import baseball.view.utils.OutputUtils;

public class ResultPrintView {

    private static final String ZERO_SCORE = "낫싱";

    public void printResult(Result result) {
        int strike = result.getStrike();
        int ball = result.getBall();
        String resultMessage = printScore(strike, ball);
        OutputUtils.outputLine(resultMessage);
    }//feat(view): add view that print result of game

    private String printScore(int strike, int ball) {

        StringBuilder resultMessage = new StringBuilder();
        if (isNotEmpty(ball)) {
            resultMessage.append(ball + "볼");
        }
        if (isNotEmpty(strike)) {
            resultMessage.append(" ");
            resultMessage.append(strike + "스트라이크");
        }
        if (doesNotMatchAnything(resultMessage)) {
            resultMessage.append(ZERO_SCORE);
        }
        return resultMessage.toString().trim();
    }

    private boolean isNotEmpty(int value) {
        return (value != 0);
    }

    private boolean doesNotMatchAnything(StringBuilder stringBuilder) {
        return (stringBuilder.length() == 0);
    }
}
