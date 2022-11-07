package baseball.view;

public enum SystemMessage {
    INPUT_IS_NOT_A_NUMBER("숫자만을 입력해주세요."),
    INPUT_LENGTH_IS_NOT_THREE("입력값의 길이가 3이 아닙니다."),
    INPUT_NUMBER_IS_NOT_UNIQUE("입력값에 중복된 숫자가 있습니다.");

    private final String message;

    SystemMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
