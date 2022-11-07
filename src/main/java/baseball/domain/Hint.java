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

    public static void printHintByCount() {
        String hint;
        if(STRIKE.count > 0 && BALL.count > 0) {
            hint = BALL.count + BALL.value + " " + STRIKE.count + STRIKE.value;
        }
        else {
            if(BALL.count > 0) {
                hint = BALL.count + BALL.value;
            }
            else if(STRIKE.count > 0) {
                hint = STRIKE.count + STRIKE.value;
            }
            else {
                hint = NOTHING.value;
            }
        }

        System.out.println(hint);
    }

    public static int getStrikeCount() {
        return STRIKE.count;
    }

    public static void init() {
        STRIKE.count = 0;
        BALL.count = 0;
        NOTHING.count = 0;
    }
}
