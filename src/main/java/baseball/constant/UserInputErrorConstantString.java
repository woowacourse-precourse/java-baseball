package baseball.constant;

public enum UserInputErrorConstantString {
    LENGTH_ERROR(
            "integer 길이는 " + GameProcedureConstantInteger.BASEBALL_GAME_NUMBER_LENGTH.getIntegerValue() + "이어야 합니다."),
    CONTAINS_DUPLICATE_ERROR("중복된 integer value는 입력할 수 없습니다"),
    CONTAINS_NON_INTEGER_ERROR("integer 값만 입력해야 합니다."),
    NOT_BETWEEN_DESIRABLE_INTERVAL_ERROR(
            "input의 각각의 digit은 " + GameProcedureConstantInteger.RANDOM_INCLUSIVE_INTEGER_START.getIntegerValue() +
                    " 과" + GameProcedureConstantInteger.RANDOM_INCLUSIVE_INTEGER_FINISH.getIntegerValue()
                    + " 사이 숫자만 입력 가능합니다."),;

    private String stringMessage;

    UserInputErrorConstantString(String stringMessage) {
        this.stringMessage = stringMessage;
    }

    public String getStringMessage() {
        return stringMessage;
    }


}
