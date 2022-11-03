package baseball.view;

import java.util.Map;

public class SystemMessage {
    public static void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printGameResult(Map<String,Integer> result) {
        String resultMessage = "";
        Integer ball = result.get("ball");
        Integer strike = result.get("strike");
        if (ball == 0) {
            resultMessage = strike + "스트라이크";
        }

        if (strike == 0) {
            resultMessage = ball + "볼";
        }

        if(ball != 0 && strike != 0) {
            resultMessage = ball + "볼 " + strike + "스트라이크";
        }

        if (ball == 0 && strike == 0) {
            resultMessage = "낫싱";
        }

        System.out.println(resultMessage);
    }
}
