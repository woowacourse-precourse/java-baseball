package baseball.view;

import baseball.model.Result;

import java.util.ArrayList;
import java.util.List;

public class OutputView {

    private static final String SPACE_DELIMITER = " ";
    private static final int NONE_MATCH = 0;

    private OutputView() {
    }

    public static void startMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void reportResult(Result result) {
        if (result.isNothing()) {
            System.out.println("낫싱");
            return;
        }

        List<String> report = new ArrayList<>();
        if (isMatch(result.getBall())) {
            report.add(result.getBall() + "볼");
        }
        if (isMatch(result.getStrike())) {
            report.add(result.getStrike() + "스트라이크");
        }
        System.out.println(String.join(SPACE_DELIMITER, report));
    }

    private static boolean isMatch(int matchCount) {
        return matchCount != NONE_MATCH;
    }
}
