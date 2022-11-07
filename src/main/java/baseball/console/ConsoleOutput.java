package baseball.console;

import baseball.game.GameResult;

public class ConsoleOutput {

  public void printStartMessage() {
    final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    System.out.println(START_MESSAGE);
  }

  public void printEndMessage() {
    final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    System.out.println(END_MESSAGE);
  }

  public void printResult(GameResult result) {
    StringBuilder sb = new StringBuilder();
    final String STRIKE_MESSAGE = "스트라이크";
    final String BALL_MESSAGE = "볼";
    final String NOTING_MESSAGE = "낫싱";

    if (isOnlyStrike(result)) {
      sb.append(result.getStrike()).append(STRIKE_MESSAGE);
    }

    if (isOnlyBall(result)) {
      sb.append(result.getBall()).append(BALL_MESSAGE);
    }

    if (isNoting(result)) {
      sb.append(NOTING_MESSAGE);
    }

    if (isAllMatching(result)) {
      sb.append(result.getBall()).append(BALL_MESSAGE);
      sb.append(" ");
      sb.append(result.getStrike()).append(STRIKE_MESSAGE);
    }
    System.out.println(sb);
  }

  private boolean isOnlyStrike(GameResult result) {
    return !result.getStrike().equals(0) && result.getBall().equals(0);
  }

  private boolean isOnlyBall(GameResult result) {
    return result.getStrike().equals(0) && !result.getBall().equals(0);
  }

  public boolean isNoting(GameResult result) {
    return result.getStrike().equals(0) && result.getBall().equals(0);
  }

  public boolean isAllMatching(GameResult result) {
    return !result.getStrike().equals(0) && !result.getBall().equals(0);
  }
}
