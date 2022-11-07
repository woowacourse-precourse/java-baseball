package baseball.domain;

import java.util.HashMap;
import java.util.Map;

public class Hint {

    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String WIN_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final int THREE_STRIKE = 3;

    private Map<String, Integer> countResult;

    public Hint() {
        this.countResult = new HashMap<>();
    }

    public Hint(Map<String, Integer> countResult) {
        this.countResult = countResult;
    }

    private void initCountResult() {
        this.countResult.put(BaseballCount.STRIKE.getValue(), 0);
        this.countResult.put(BaseballCount.BALL.getValue(), 0);
    }

    private void countBaseballResult(Player player, Computer computer) {
        initCountResult();
        this.countResult = computer.countBallAndStrikeWithPlayer(player, this.countResult);
    }

    public String makeHintMessage() {
        Integer strike = this.countResult.get(BaseballCount.STRIKE.getValue());
        Integer ball = this.countResult.get(BaseballCount.BALL.getValue());
        String result = "";

        if (strike == THREE_STRIKE) {
            return strike + BaseballCount.STRIKE.getMessage() + "\n" + WIN_MESSAGE;
        }
        if (strike == 0 && ball == 0) {
            return NOTHING_MESSAGE;
        }
        if (ball != 0) {
            result += ball + BaseballCount.BALL.getMessage();
        }
        if (strike != 0) {
            if (ball != 0) {
                result += " ";
            }
            result += strike + BaseballCount.STRIKE.getMessage();
        }
        return result;
    }

    public String getBaseballResult(Player player, Computer computer) {
        countBaseballResult(player, computer);
        return makeHintMessage();
    }

    public boolean isThreeStrike() {
        return this.countResult.get(BaseballCount.STRIKE.getValue()) == THREE_STRIKE;
    }
}
