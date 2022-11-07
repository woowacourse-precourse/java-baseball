package baseball.model;


import java.util.Map;
import java.util.stream.Collectors;

public class BaseBallResult {

    public static String result(Map<BaseBallHitsType, Integer> result) {
        String strike = strike(result);

        if (strike.isBlank()) {
            return BaseBallHitsType.NOTING.getBallResultType();
        }

        return strike;
    }

    public static String strike(Map<BaseBallHitsType, Integer> result) {
        return result.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .filter(hitResult -> hitResult.getValue() != 0 && !hitResult.getKey().equals(BaseBallHitsType.NOTING))
                .map(strike -> strike.getValue() + strike.getKey().getBallResultType() + " ")
                .collect(Collectors.joining());
    }

}
