package baseball.view;

import baseball.domain.Result;
import java.util.ArrayList;
import java.util.List;

public class OutputView {
    private OutputView() {
    }

    public static void printResult(Result result) {
        int strike = result.getStrike();
        int ball = result.getBall();
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return;
        }
        List<String> resultMessages = getResultMessage(strike, ball);
        System.out.println(String.join(" ", resultMessages));
    }

    private static List<String> getResultMessage(int strike, int ball) {
        List<String> resultMessages = new ArrayList<>();
        if (ball > 0) {
            resultMessages.add(ball + "볼");
        }
        if (strike > 0) {
            resultMessages.add(strike + "스트라이크");
        }
        return resultMessages;
    }
}
