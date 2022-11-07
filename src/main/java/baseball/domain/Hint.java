package baseball.domain;

public enum Hint {
    STRIKE("스트라이크", 0),
    BALL("볼", 0),
    NOTHING("낫싱", 0);

    private String value;
    private int count;

    Hint() {}

    Hint(String value, int count) {
        this.value = value;
        this.count = count;
    }

    public static void addCount(Hint hint) {
        hint.count++;
    }

    public static String getHintByCount() {
        if(STRIKE.count > 0 && BALL.count > 0) {
            return BALL.count + BALL.value + " " + STRIKE.count + STRIKE.value;
        }
        if(BALL.count > 0) {
            return BALL.count + BALL.value;
        }
        else if(STRIKE.count > 0) {
            return STRIKE.count + BALL.value;
        }
        return NOTHING.value;
    }

    public static int getStrikeCount() {
        return STRIKE.count;
    }
}
