package baseball;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private static final String STRIKE = "strike";
    private static final String BALL = "ball";

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

}
