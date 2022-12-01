package baseball;

public class ScoreBoard {
    private final String BALL = "볼 ";
    private final String STRIKE = "스트라이크";
    private final String NOTHING = "낫싱";
    private final String WIN_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final String EMPTY = "";
    private final int NONE = 0;
    private final int WIN_STRIKE_NUMBER = 3;

    private int ball;
    private int strike;

    public ScoreBoard(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public String get() {
        StringBuilder result = new StringBuilder("");
        result.append(getBallResult());
        result.append(getStrikeResult());
        result.append(getNothingResult());
        result.append(getGameWinResult());
        return result.toString();
    }

    private String getGameWinResult() {
        if (strike == WIN_STRIKE_NUMBER) {
            return WIN_MESSAGE;
        }
        return EMPTY;
    }

    private String getBallResult() {
        if (ball > NONE) {
            return new String(integerToString(ball) + BALL);
        }
        return EMPTY;
    }

    private String getStrikeResult() {
        if (strike > NONE) {
            return new String(integerToString(strike) + STRIKE);
        }
        return EMPTY;
    }

    private String getNothingResult() {
        if (ball == NONE && strike == NONE) {
            return NOTHING;
        }
        return EMPTY;
    }

    private String integerToString(int value) {
        return Integer.toString(value);
    }
}
