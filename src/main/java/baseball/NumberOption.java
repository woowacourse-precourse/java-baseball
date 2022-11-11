package baseball;

public enum NumberOption {
    START_INCLUSIVE(1),
    END_INCLUSIVE(9),
    COUNT(3),
    ;

    private final int value;


    NumberOption(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
