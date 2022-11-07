package baseball.model;

import java.util.Map;

import static baseball.resources.GameConfig.*;

public class Result {
    private final Map<String, Integer> result;

    public Result(Map<String, Integer> result) {
        this.result = result;
    }

    public Map<String, Integer> getEachCount(){
        return result;
    }

    public boolean isFinish(){
        return result.get(STRIKE_COUNT) == SIZE;
    }

    public boolean hasBall() {
        return result.getOrDefault(BALL_COUNT, 0) > 0;
    }

    public boolean hasStrike() {
        return result.getOrDefault(STRIKE_COUNT, 0) > 0;
    }

    public boolean hasBallAndStrike() {
        return hasBall() && hasStrike();
    }
}
