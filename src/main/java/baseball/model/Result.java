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
        return count(strike()) == GameConfig.SIZE;
    }

    public boolean hasBall() {
        return count(ball()) > 0;
    }

    public boolean hasStrike() {
        return count(strike()) > 0;
    }

    public boolean hasBallAndStrike() {
        return hasBall() && hasStrike();
    }

    public Map<String, Integer> getEachCount(){
        Map<String, Integer> result = new HashMap<>();
        result.put(STRIKE_COUNT, count(strike()));
        result.put(BALL_COUNT, count(ball()));
        return result;
    }

    private Predicate<Numbers> strike() {
        return number -> number.isStrike(gameNumber);
    }

    private Predicate<Numbers> ball() {
        return number -> number.isBall(gameNumber);
    }

    private int count(Predicate<Numbers> predicate) {
        return (int) numbers.stream()
                .filter(predicate)
                .count();
    }
}
