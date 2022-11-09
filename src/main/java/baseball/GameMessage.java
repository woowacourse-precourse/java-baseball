package baseball;

public enum GameMessage {
  GAME_START_MESSAGE("숫자 야구 게임을 시작합니다."),
  START_INPUT_MESSAGE("숫자를 입력해주세요: "),
  TRY_COUNT_MESSAGE("번의 시도 끝에"),
  GAME_FINISH_MESSAGE("개의 숫자를 모두 맞히셨습니다! 게임 종료"),
  CHECK_RESTART_MESSAGE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
  IS_INVALID_VALUE("잘못된 값을 입력하셨습니다. 다시 입력해주세요.");
  private final String message;

  GameMessage(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public static String getFinishMessage(int tryCount, int numberDigit) {
    return tryCount
        + TRY_COUNT_MESSAGE.getMessage()
        + " "
        + numberDigit
        + GAME_FINISH_MESSAGE.getMessage();
  }
}
