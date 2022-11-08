package baseball.constant;

public enum InGameMessages {
  GAME_START("숫자 야구 게임을 시작합니다."),
  ENTER_NUMBER("숫자를 입력해 주세요 : "),
  GAME_END("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
  GAME_RESTART_OR_END("게임을 새로 시작하려면 1 , 종료하려면 2를 입력하세요.");

  private String message;

  InGameMessages(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
