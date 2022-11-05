package baseball.constant;

public enum GameProcedureConstantInteger {
    RANDOM_INCLUSIVE_INTEGER_START(1),
    RANDOM_INCLUSIVE_INTEGER_FINISH(9),
    BASEBALL_GAME_NUMBER_LENGTH(3);

    private int integerValue;

    GameProcedureConstantInteger(int integerValue) {
        this.integerValue = integerValue;
    }

    public int getIntegerValue() {
        return integerValue;
    }
}
