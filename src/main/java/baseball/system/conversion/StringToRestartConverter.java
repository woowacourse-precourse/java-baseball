package baseball.system.conversion;

import baseball.vo.Restart;

import static baseball.vo.Restart.*;

public class StringToRestartConverter implements Converter<String, Restart> {
    public static final String INVALID_INPUT_VALUE_MESSAGE = "재시작 여부를 결정하는 유효한 입력이 아닙니다.";

    @Override
    public boolean supports(Object from, Class to) {
        return from.getClass() == String.class && to == Restart.class;
    }

    @Override
    public Restart convert(String target) {
        if (RESTART.getValue().equals(target)) {
            return RESTART;
        } else if (EXIT.getValue().equals(target)) {
            return EXIT;
        }

        throw new IllegalArgumentException(INVALID_INPUT_VALUE_MESSAGE);
    }
}
