package baseball.model;

import baseball.util.ExceptionMessage;
import java.util.Arrays;

public enum BallCount {
    STRIKE(true, true),
    BALL(true, false),
    NOTHING(false, false);

    private final boolean hasCommonNumber;
    private final boolean isInSamePosition;


    BallCount(boolean hasCommonNumber, boolean isInSamePosition) {
        this.hasCommonNumber = hasCommonNumber;
        this.isInSamePosition = isInSamePosition;
    }

    public static BallCount decideBallCount(boolean hasCommonNumber, boolean isInSamePosition) {
        return Arrays.stream(BallCount.values())
                .filter(ballCount -> ballCount.hasCommonNumber == hasCommonNumber)
                .filter(ballCount -> ballCount.isInSamePosition == isInSamePosition)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.INVALID_BALL_COUNT.getMessage()));
    }

}
