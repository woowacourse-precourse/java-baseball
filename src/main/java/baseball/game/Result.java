package baseball.game;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final int THREE_STRIKE = 3;
    private static final int ZERO = 0;
    private static final String NOTHING = "낫싱";
    private static final String GAME_END = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String WHITE_SPACE = " ";

    private Map<String, Integer> result;

    private Result(int strikeCount, int ballCount) {
        this.result = new HashMap<>();
        result.put(STRIKE, strikeCount);
        result.put(BALL, ballCount);
    }

    public static Result scoreOf(int strikeCount, int ballCount) {
        return new Result(strikeCount, ballCount);
    }

    public int countStrike() {
        return this.result.get(STRIKE);
    }

    public int countBall() {
        return this.result.get(BALL);
    }

    public boolean isEnd() {
        if (countStrike() == THREE_STRIKE) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if (countStrike() == ZERO && countBall() == ZERO) {
            return NOTHING;
        }
        if (isEnd()) {
            return GAME_END;
        }
        return buildAnswerAnnouncement();
    }

    private String buildAnswerAnnouncement() {
        StringBuilder announcement = new StringBuilder();
        if (countBall() == ZERO) {
            return announcement.append(countStrike() + STRIKE).toString();
        }
        if (countStrike() == ZERO) {
            return announcement.append(countBall() + BALL).toString();
        }
        return announcement.append(countBall() + BALL + WHITE_SPACE + countStrike() + STRIKE).toString();
    }

}
