package baseball.message;

public enum GameMessage {
  START_GAME("숫자 야구 게임을 시작합니다."),
  STRIKE_OUT("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

  private final String message;

  GameMessage(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
