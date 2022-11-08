package baseball.model;


import java.util.Map;
import java.util.stream.Collectors;

public class BaseBallResult {

    public static boolean end(Map<BaseBallHitsType, Integer> hitResult) {
        return hitResult.entrySet().stream()
                .filter(hitEntry -> hitEntry.getKey().equals(BaseBallHitsType.STRIKE))
                .anyMatch(strikeEntry -> strikeEntry.getKey().getBallJudgement().equals(strikeEntry.getValue()));
    }

    public static String hitResult(Map<BaseBallHitsType, Integer> hitTypeResult) {

        if (notHit(hitTypeResult)) {
            return BaseBallHitsType.NOTING.hitType();
        }

        return hit(hitTypeResult);
    }

    private static String hit(Map<BaseBallHitsType, Integer> hitResult) {

        return hitResult.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .filter(hit -> hit.getValue() != 0 && !hit.getKey().equals(BaseBallHitsType.NOTING))
                .map(hit -> hit.getValue() + hit.getKey().hitType())
                .collect(Collectors.joining());
    }

    private static boolean notHit(Map<BaseBallHitsType, Integer> hitResult) {

        return hitResult.entrySet().stream()
                .filter(hit -> hit.getValue() != 0 && !hit.getKey().equals(BaseBallHitsType.NOTING))
                .findAny()
                .isEmpty();
    }
}
