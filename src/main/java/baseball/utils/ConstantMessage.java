package baseball.utils;

public enum ConstantMessage {
    ISDIGIT_EXCEPTION("숫자가 아닙니다."),
    DUPLICATION_EXCEPTION("중복된 숫자가 존재합니다."),
    VALID_NUMBER_EXCEPTION("가능하지 않은 숫자 입니다."),
    NUMBER_LENGTH_EXCEPTION("글자의 길이가 초과되었습니다."),
    INPUT_NUMBER("숫자를 입력해주세요 : ");

    private final String constant;

    ConstantMessage(String constant) {
        this.constant = constant;
    }

    public String getConstant() {
        return constant;
    }
}
