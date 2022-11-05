package baseball;

import java.util.HashMap;
import java.util.Map;

public class Hint {

    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String WIN_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private Map<String, Integer> countResult;

    public Hint() {
        this.countResult = new HashMap<>();
    }

    private void initCountResult() {
        this.countResult.put("strike", 0);
        this.countResult.put("ball", 0);
    }

    private void countBaseballResult(Player player, Computer computer) {
        initCountResult();
        this.countResult = computer.countBallAndStrikeWithPlayer(player, this.countResult);
    }

    private String makeHintMessage() {
        Integer strike = this.countResult.get("strike");
        Integer ball = this.countResult.get("ball");
        String result = "";
        if (strike == 3 && ball == 0) {
            result = strike + STRIKE_MESSAGE + "\n" + WIN_MESSAGE;
        } else if (strike == 0 && ball == 0) {
            result = NOTHING_MESSAGE;
        } else if (strike == 0 && ball > 0) {
            result = ball + BALL_MESSAGE;
        } else if (strike > 0 && ball == 0) {
            result = strike + STRIKE_MESSAGE;
        } else if (strike > 0 && ball > 0) {
            result = ball + BALL_MESSAGE + " " + strike + STRIKE_MESSAGE;
        }
        return result;
    }

    public String getBaseballResult(Player player, Computer computer) {
        countBaseballResult(player, computer);
        return makeHintMessage();
    }
}