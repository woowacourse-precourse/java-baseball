package baseball.exception;

public enum ErrorMessage {
    DUPLICATION_NUMBER("입력한 문자에 중복이 있습니다."),
    INPUT_SIZE("입력한 문자의 크기가 올바르지 않습니다."),
    NOT_DIGIT("입력한 문자 중 숫자가 아닌 문자가 포함되어 있습니다."),
    NOT_RUN_CODE("해당 명령어는 존재하지 않습니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message + " 게임을 종료합니다.";
    }
}
