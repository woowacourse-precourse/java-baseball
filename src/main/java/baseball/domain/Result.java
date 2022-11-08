package baseball.domain;

import java.util.EnumMap;
import java.util.Map;

public class Result {

    private Map<ResultType, Integer> result;

    public Result() {
        this.result = new EnumMap<>(ResultType.class);

        for (ResultType resultType : ResultType.values()) {
            this.result.put(resultType, 0);
        }
    }

    public int get(ResultType resultType) {
        return this.result.get(resultType);
    }

    public void add(ResultType resultType) {
        Integer added = this.result.get(resultType) + 1;
        this.result.put(resultType, added);
    }

    public boolean isNothing() {
        return (this.result.get(ResultType.BALL) == 0) && (this.result.get(ResultType.STRIKE) == 0);
    }

    public boolean isCorrect(int digit) {
        return this.result.get(ResultType.STRIKE) == digit;
    }

}
