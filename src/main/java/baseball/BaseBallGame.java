package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseBallGame {
  private Computer computer = new Computer();
  private int tryCount = 0;

  public void start() {
    gameInit();
    System.out.println(GameMessage.GAME_START_MESSAGE.getMessage());
    GameNumber gameNumber;
    GameResult result = new GameResult();
    boolean isGameOver = false;
    while (!isGameOver) {
      tryCount++;
      gameNumber = getUserNumberInput();
      result.setResultByGameNumber(computer.getAnswerNumber(), gameNumber);
      System.out.println(result.getResultString());
      if (result.isAnswer()) {
        System.out.println(
            tryCount
                + "번의 시도끝에 "
                + GameNumber.NUMBER_DIGIT
                + GameMessage.GAME_FINISH_MESSAGE.getMessage());
        isGameOver = !checkRestart();
      }
    }
  }

  // 재시작 할 것인지 체크
  private boolean checkRestart() {
    System.out.println(GameMessage.CHECK_RESTART_MESSAGE.getMessage());
    while (true) {
      String input = Console.readLine();
      switch (input) {
        case "1":
          gameInit();
          return true;
        case "2":
          return false;
        default:
          System.out.println(GameMessage.IS_INVALID_VALUE.getMessage());
      }
    }
  }

  private void gameInit() {
    computer.setAnswerNumber();
    tryCount = 0;
  }

  private GameNumber getUserNumberInput() {
    System.out.print(GameMessage.START_INPUT_MESSAGE.getMessage());
    return createGameNumber(Console.readLine());
  }

  private GameNumber createGameNumber(String inputData) {
    GameNumber gameNumber = new GameNumber();
    gameNumber.setGameNumberByString(inputData);
    return gameNumber;
  }
}
