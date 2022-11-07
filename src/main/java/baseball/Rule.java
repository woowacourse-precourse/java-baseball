package baseball;

public enum Rule {
    DIGITS(3) , RANDOM_MIN(1), RANDOM_MAX(9), COMMAND_RESTART(1),COMMAND_END(2);

    private final int value;

    Rule(int value) {
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    @Override
    public String toString(){
        return String.valueOf(this.value);
    }
}
