package baseball.message;

public enum InputMessage {

  INPUT_PLAYER_BALLS("숫자를 입력해주세요. : "),
  ASK_RESTART_GAME("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

  private final String message;

  InputMessage(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
