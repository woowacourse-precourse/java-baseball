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
      gameNumber = getGameNumberByUserInput();
      result.setResultByGameNumber(computer.getAnswerNumber(), gameNumber);
      System.out.println(result.getResultString());
      if (result.isAnswer()) {
        System.out.println(GameMessage.getFinishMessage(tryCount, GameNumber.NUMBER_DIGIT));
        isGameOver = !checkRestart();
        if (!isGameOver) gameInit();
      }
    }
  }

  // 재시작 할 것인지 체크
  private boolean checkRestart() {
    System.out.println(GameMessage.CHECK_RESTART_MESSAGE.getMessage());
    while (true) {
      String input = Console.readLine();
      if (input.equals("1")) return true;
      if (input.equals("2")) return false;
      System.out.println(GameMessage.IS_INVALID_VALUE.getMessage());
    }
  }

  private void gameInit() {
    computer.setAnswerNumber();
    tryCount = 0;
  }

  private GameNumber getGameNumberByUserInput() {
    System.out.print(GameMessage.START_INPUT_MESSAGE.getMessage());
    return createGameNumber(Console.readLine());
  }

  private GameNumber createGameNumber(String inputData) {
    GameNumber gameNumber = new GameNumber();
    gameNumber.setGameNumberByString(inputData);
    return gameNumber;
  }
}
