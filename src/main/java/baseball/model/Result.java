package baseball.model;

import baseball.resources.GameConfig;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static baseball.resources.GameConfig.*;

public class Result {
    private final List<Numbers> numbers;
    private final List<Integer> gameNumber;

    public Result(List<Numbers> numbers, List<Integer> gameNumber) {
        this.numbers = numbers;
        this.gameNumber = gameNumber;
    }

    public boolean isFinish(){
        return count(number -> number.isStrike(gameNumber)) == GameConfig.SIZE;
    }

    public boolean hasBall() {
        return count(number -> number.isBall(gameNumber)) > 0;
    }

    public boolean hasStrike() {
        return count(number -> number.isStrike(gameNumber)) > 0;
    }

    public boolean hasBallAndStrike() {
        return hasBall() && hasStrike();
    }

    public Map<String, Integer> getEachCount(){
        Map<String, Integer> result = new HashMap<>();
        result.put(STRIKE_COUNT, count(number -> number.isStrike(gameNumber)));
        result.put(BALL_COUNT, count(number -> number.isBall(gameNumber)));
        return result;
    }

    private int count(Predicate<Numbers> predicate) {
        return (int) numbers.stream()
                .filter(predicate)
                .count();
    }
}
