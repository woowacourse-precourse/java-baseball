package baseball.domain;

import java.util.List;
import java.util.Map;

public class Game {
    private final Result result;

    public Game(List<Integer> randomNumberList) {
        this.result = new Result(randomNumberList);
    }

    public Map<String, Integer> getResult(List<Integer> userAnswer) {
        return result.getResult(userAnswer);
    }
}
