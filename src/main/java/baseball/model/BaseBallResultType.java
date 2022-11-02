package baseball.model;

import org.assertj.core.util.TriFunction;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum BaseBallResultType {
    STRIKE("스트라이크", (homeRun, input, index) -> homeRun.charAt(index) == input.charAt(index)),
    BALL("볼", (homeRun, input, index) -> input.indexOf(homeRun.charAt(index)) >= 0 && input.charAt(index) != homeRun.charAt(index)),
    NOTING("낫싱", (homeRun, input, index) -> input.indexOf(homeRun.charAt(index)) < 0);
    private String ballResultType;

    private TriFunction<String, String, Integer, Boolean> isType;

    BaseBallResultType(String ballResultType, TriFunction<String, String, Integer, Boolean> isType) {
        this.ballResultType = ballResultType;
        this.isType = isType;
    }

    public static BaseBallResultType findBallResultType(String homeRun, String input, int index) {
        return Arrays.stream(BaseBallResultType.values())
                .filter(baseBallResultType -> baseBallResultType.isType.apply(homeRun, input, index))
                .findAny()
                .orElseThrow();
    }

    public TriFunction<String, String, Integer, Boolean> getIsType() {
        return isType;
    }
}
