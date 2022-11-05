package baseball.constant;

public enum GameProcedureConstantInteger {
    RANDOM_INCLUSIVE_INTEGER_START(1),
    RANDOM_INCLUSIVE_INTEGER_FINISH(9),
    BASEBALL_GAME_NUMBER_LENGTH(3),
    BASEBALL_GAME_RETRY_REPLY_LENGTH(1),
    BASEBALL_GAME_RETRY_REPLY_INCLUSIVE_INTEGER_START(1),
    BASEBALL_GAME_RETRY_REPLY_INCLUSIVE_INTEGER_FINISH(2);

    private int integerValue;

    GameProcedureConstantInteger(int integerValue) {
        this.integerValue = integerValue;
    }

    public int getIntegerValue() {
        return integerValue;
    }
}
