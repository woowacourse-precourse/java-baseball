package baseball.system.conversion;

import baseball.vo.Restart;

public class StringToRestartConverter implements Converter<String, Restart> {

    public static final String INVALID_INPUT_VALUE_MESSAGE = "재시작 여부를 결정하는 유효한 입력이 아닙니다.";
    public static final String RESTARTING_VALUE = "1";
    public static final String EXIT_VALUE = "2";

    @Override
    public Restart convert(String target) {
        if (RESTARTING_VALUE.equals(target)) {
            return Restart.RESTART;
        } else if (EXIT_VALUE.equals(target)) {
            return Restart.EXIT;
        }

        throw new IllegalArgumentException(INVALID_INPUT_VALUE_MESSAGE);
    }
}
