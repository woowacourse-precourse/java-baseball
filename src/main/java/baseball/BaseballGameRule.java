package baseball;

public enum BaseballGameRule {
    LENGTH(3),
    RANGEFROM(1),
    RANGETO(9);

    private int value;

    BaseballGameRule(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
