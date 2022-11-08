package baseball;

import baseball.GameNumber;

import java.util.List;

public class GameResult {
  private int strikeCount;
  private int ballCount;

  public void setResultByGameNumber(
          GameNumber answerNumber, GameNumber gameNumber) {
    List<Integer> answerNumberList = answerNumber.getGameNumberList();
    List<Integer> gameNumberList = gameNumber.getGameNumberList();
    strikeCount = 0;
    ballCount = 0;
    calculateResult(answerNumberList, gameNumberList);
  }

  public void printResult() {
    String result = "";
    if (strikeCount + ballCount == 0) result += "낫싱";
    else  {
      if (ballCount != 0) result += ballCount + "볼 ";
      if (strikeCount != 0) result += strikeCount + "스트라이크";
    }
    System.out.println(result);
  }

  public boolean isAnswer() {
    return strikeCount == 3;
  }

  private void calculateResult(List<Integer> answerNumberList, List<Integer> gameNumberList) {
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
