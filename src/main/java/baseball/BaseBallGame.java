package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseBallGame {
  private Computer computer;

  public void start() {
    gameInit();
    System.out.println(GameMessage.GAME_START_MESSAGE.toString());
    String inputData;
    BaseBallGameNumber gameNumber;
    boolean isGameOver = false;
    while (!isGameOver) {
      inputData = getUserNumberInput();
      gameNumber = createBaseBallGameNumber(inputData);
      if (gameNumber == null) isGameOver = true;
    }
  }

  private void gameInit() {
    computer = new Computer();
    computer.setAnswerNumber();
  }

  private String getUserNumberInput() {
    System.out.print(GameMessage.START_INPUT_MESSAGE.toString());
    return Console.readLine();
  }

  public BaseBallGameNumber createBaseBallGameNumber(String inputData) {
    BaseBallGameNumber gameNumber = new BaseBallGameNumber();
    try {
      gameNumber.stringToGameNumber(inputData);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      return null;
    }
    return gameNumber;
  }

  private enum GameMessage {
    GAME_START_MESSAGE("숫자 야구 게임을 시작합니다."),
    START_INPUT_MESSAGE("숫자를 입력해주세요: "),
    GAME_FINISH_MESSAGE("3개의 숫자를 모두 맞히셨습니다! 게임종료"),
    CHECK_RESTART_MESSAGE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    IS_INVALID_VALUE("잘못된 값을 입력하셨습니다. 다시 입력해주세요.");
    private final String message;

    GameMessage(String message) {
      this.message = message;
    }

    public String toString() {
      return message;
    }
  }
}
