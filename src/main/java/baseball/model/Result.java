package baseball.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static baseball.resources.GameConfig.*;

public class Result {
    private final List<InputNumber> inputNumber;
    private final BaseNumber baseNumber;

    public Result(List<InputNumber> inputNumber, BaseNumber baseNumber) {
        this.inputNumber = inputNumber;
        this.baseNumber = baseNumber;
    }

    public boolean isFinish(){
        return count(strike()) == SIZE;
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

    private Predicate<InputNumber> strike() {
        return number -> number.isStrike(baseNumber);
    }

    private Predicate<InputNumber> ball() {
        return number -> number.isBall(baseNumber);
    }

    private int count(Predicate<InputNumber> predicate) {
        return (int) inputNumber.stream()
                .filter(predicate)
                .count();
    }
}
