package baseball;

import java.util.List;

public class GameResult {
  private int strikeCount;
  private int ballCount;

  public void setResultByGameNumber(
      BaseBallGameNumber answerNumber, BaseBallGameNumber gameNumber) {
    List<Integer> answerNumberList = answerNumber.getGameNumberList();
    List<Integer> gameNumberList = gameNumber.getGameNumberList();
    strikeCount = 0;
    ballCount = 0;
    calculateStrike(answerNumberList, gameNumberList);
  }

  public void printResult() {
    if (ballCount != 0) {
      System.out.print(ballCount + "볼 ");
    }
    if (strikeCount != 0) {
      System.out.print(strikeCount + "스트라이크");
    }
    if (strikeCount + ballCount == 0) {
      System.out.print("낫싱");
    }
    System.out.println();
  }

  public boolean isAnswer() {
    return strikeCount == 3;
  }

  private void calculateStrike(List<Integer> answerNumberList, List<Integer> gameNumberList) {
    for (int i = 0; i < answerNumberList.size(); i++) {
      for (int j = 0; j < gameNumberList.size(); j++) {
        if (answerNumberList.get(i) == gameNumberList.get(j)) {
          if (i == j) strikeCount++;
          else ballCount++;
          break;
        }
      }
    }
  }
}
