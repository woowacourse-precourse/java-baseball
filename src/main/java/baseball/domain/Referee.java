package baseball.domain;

public enum Referee {
    STRIKE(false, true, "%d스트라이크"),
    BALL(true, false, "%d볼"),
    STRIKE_BALL(false,false,"%d볼 %d스트라이크"),
    NOTHING(true, true, "낫싱");

    private final boolean isStrikeZero;
    private final boolean isBallZero;
    private final String message;

    Referee(boolean isStrikeZero, boolean isBallZero, String message) {
        this.isStrikeZero = isStrikeZero;
        this.isBallZero = isBallZero;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    private static boolean isZero(int count) {
        return count == 0;
    }

    public static Referee ballCountToMessage(int strikeCount, int ballCount) {
        for (Referee referee : Referee.values()) {
            if(isZero(strikeCount) == referee.isStrikeZero && isZero(ballCount) == referee.isBallZero) {
                return referee;
            }
        }
        return NOTHING;
    }
}
