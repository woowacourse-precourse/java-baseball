package baseball.utils;

public enum Constant implements defaultValue {
    ISDIGIT_EXCEPTION("숫자가 아닙니다."),
    DUPLICATION_EXCEPTION("중복된 숫자가 존재합니다."),
    VALID_NUMBER_EXCEPTION("가능하지 않은 숫자 입니다."),
    NUMBER_LENGTH_EXCEPTION("글자의 길이가 초과되었습니다."),
    INPUT_NUMBER("숫자를 입력해주세요 : "),
    MIN_NUM(1),
    MAX_NUM(9);;

    private final String constant;
    private final int constantNumber;

    ConstantMessage(String constant) {
        this.constant = constant;
        this.constantNumber = DEFAULT_NUMBER;
    }

    ConstantMessage(int constant) {
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
