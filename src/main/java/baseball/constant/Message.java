package baseball.constant;

public class Message {
    public static final String TYPE_EXCEPTION = "숫자를 입력해주세요.";
    public static final String DIGIT_LENGTH_EXCEPTION = Config.DIGIT_SIZE + "자리 수를 입력해주세요.";
    public static final String STATE_LENGTH_EXCEPTION = Config.STATE_SIZE + "자리 수를 입력해주세요.";
    public static final String DUPLICATION_EXCEPTION = "서로 다른 수를 입력해주세요.";
    public static final String DIGIT_RANGE_EXCEPTION = Config.DIGIT_MIN + "부터 " + Config.DIGIT_MAX + "까지의 수를 입력해주세요.";
    public static final String STATE_NUMBER_EXCEPTION = State.RESTART.getNumber() + " 또는 " + State.SHUTDOWN.getNumber() + "를 입력해주세요.";
}
