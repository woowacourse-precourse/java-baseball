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
