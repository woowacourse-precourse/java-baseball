package baseball.utils;

public enum Constant implements defaultValue {
    ISDIGIT_EXCEPTION("숫자가 아닙니다."),
    DUPLICATION_EXCEPTION("중복된 숫자가 존재합니다."),
    VALID_NUMBER_EXCEPTION("가능하지 않은 숫자 입니다."),
    NUMBER_LENGTH_EXCEPTION("글자의 길이가 초과되었습니다."),
    INPUT_NUMBER("숫자를 입력해주세요 : "),
    START_GAME("숫자 야구 게임을 시작합니다."),
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱"),
    IS_CONTINUE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    RESTART_EXCEPTION("1 또는 2만 입력이 가능합니다."),
    END_GAME("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    IS_ANSWER(3),
    IS_NONE(0),
    RESTART_NUMBER_LENGTH(1),
    RESTART_NUMBER_MIN(1),
    RESTART_NUMBER_MAX(2),
    RESTART(1),
    EXIT(2),
    MIN_NUM(1),
    MAX_NUM(9);;

    private final String constant;
    private final int constantNumber;

    Constant(String constant) {
        this.constant = constant;
        this.constantNumber = DEFAULT_NUMBER;
    }

    Constant(int constant) {
        this.constant = DEFAULT_MESSAGE;
        this.constantNumber = constant;
    }

    public String getMessage() {
        return constant;
    }

    public int getNumber() {
        return constantNumber;
    }
}

interface defaultValue {
    String DEFAULT_MESSAGE = "";
    int DEFAULT_NUMBER = 0;
}
