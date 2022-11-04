package baseball;

import java.util.List;

public class Hint {

    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String WIN_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final Integer BASEBALL_NUMBERS_LENGTH = 3;

    private Integer strike;

    private Integer ball;

    public Integer getStrike() {
        return strike;
    }

    public void resetHintCount() {
        this.strike = 0;
        this.ball = 0;
    }

    public void countBaseballResult(List<Integer> player, List<Integer> computer) {
        resetHintCount();
        for (int i = 0; i < BASEBALL_NUMBERS_LENGTH; i++) {
            if (player.get(i) == computer.get(i)) {
                this.strike += 1;
            } else if (computer.contains(player.get(i))) {
                this.ball += 1;
            }
        }
    }

    private String makeHintMessage() {
        String result = "";
        if (this.strike == 3 && this.ball == 0) {
            result = this.strike + STRIKE_MESSAGE + "\n" + WIN_MESSAGE;
        } else if (this.strike == 0 && this.ball == 0) {
            result = NOTHING_MESSAGE;
        } else if (this.strike == 0 && this.ball > 0) {
            result += this.ball + BALL_MESSAGE;
        } else if (this.strike > 0 && this.ball == 0) {
            result = this.strike + STRIKE_MESSAGE;
        } else if (this.strike > 0 && this.ball > 0) {
            result = this.ball + BALL_MESSAGE + " " + this.strike + STRIKE_MESSAGE;
        }
        return result;
    }

    public String getBaseballResult(List<Integer> player, List<Integer> computer) {
        countBaseballResult(player, computer);
        return makeHintMessage();
    }
}
