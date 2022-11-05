package baseball;

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

    public void add(ResultType resultType) {
        Integer added = this.result.get(resultType) + 1;
        this.result.put(resultType, added);
    }

}
