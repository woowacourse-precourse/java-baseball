package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseBallGame {
  public void start() {
    System.out.println(GameMessage.GAME_START_MESSAGE.toString());
    String inputData = getUserNumberInput();
  }

  private String getUserNumberInput() {
    System.out.print(GameMessage.START_INPUT_MESSAGE.toString());
    return Console.readLine();
  }

  private enum GameMessage {
    GAME_START_MESSAGE("숫자 야구 게임을 시작합니다."),
    START_INPUT_MESSAGE("숫자를 입력해주세요: ");
    private final String message;

    GameMessage(String message) {
      this.message = message;
    }

    public String toString() {
      return message;
    }
  }
}
