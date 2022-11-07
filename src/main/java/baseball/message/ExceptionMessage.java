package baseball.message;

public enum ExceptionMessage {
  INCORRECT_BALL_SIZE("3자리 수를 입력해주세요."),
  NULL_INPUT("입력값이 존재하지 않습니다."),
  INCORRECT_INPUT("입력값은 1~9사이에 숫자여야 합니다"),
  DUPLICATE_NUMBER("숫자를 중복되지 않게 입력해주세요."),
  INCORRECT_MENU_NUMBER("메뉴는 1,2 중에 하나 입니다.");

  private final String errorMessage;

  ExceptionMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public String getErrorMessage() {
    return errorMessage;
  }
}
