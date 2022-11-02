package baseball;

public enum InGameMessages {
  GAME_START("숫자 야구 게임을 시작합니다."),
  ENTER_NUMBER("숫자를 입력해 주세요 : "),
  BALL("볼"),
  STRIKE("스트라이크"),
  GAME_END("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
  //TODO 3개가 아니라 더 많은 숫자가 되면? -> refactoring
  GAME_RESTART_OR_END("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
  //TODO 1,2가 아니라 다른 인풋으로 바뀌면? -> refactoring


  private String message;

  InGameMessages(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
