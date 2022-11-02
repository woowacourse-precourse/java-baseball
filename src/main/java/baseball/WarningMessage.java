package baseball;

public enum WarningMessage {
    IllegalArgumentExceptionWarningMessage("잘못된 값을 입력했습니다.");

    private final String message;

    WarningMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
