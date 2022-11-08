package baseball.domain;

/**
 * 숫자야구 힌트가 담긴 클래스
 */
public class Hint {
    private int ball;
    private int strike;

    public Hint() {
        this.ball = 0;
        this.strike = 0;
    }

    public void increaseBall() {
        this.ball += 1;
    }

    public void increaseStrike() {
        this.strike += 1;
    }

    public String getHintMessage() {
        String hintMessage;

        if (isExistsBall() && isExistsStrike()) {
            hintMessage = getBallMessage() + " " + getStrikeMessage();
        } else if (isExistsBall()) {
            hintMessage = getBallMessage();
        } else if (isExistsStrike()) {
            hintMessage = getStrikeMessage();
        } else {
            hintMessage = "낫싱";
        }

        return hintMessage;
    }

    public boolean isExistsBall() {
        if (this.ball > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isExistsStrike() {
        if (this.strike > 0) {
            return true;
        } else {
            return false;
        }
    }

    public String getBallMessage() {
        return ball + "볼";
    }

    public String getStrikeMessage() {
        return strike + "스트라이크";
    }

    public boolean isAllStrike() {
        if (this.strike == 3) {
            return true;
        } else {
            return false;
        }
    }

}
