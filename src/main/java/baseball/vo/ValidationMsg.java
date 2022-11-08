package baseball.vo;

public enum ValidationMsg {
    NUMBER_RANGE_EXCEPTION("입력 가능한 숫자의 범위는 1 ~ 9사이 입니다."),
    NUMBERS_SIZE_EXCEPTION("입력 가능한 숫자의 개수는 3개 입니다."),
    NUMBER_DUPLICATE_EXCEPTION("중복된 숫자는 입력이 불가능 합니다.");

    private final String message;

    ValidationMsg(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
