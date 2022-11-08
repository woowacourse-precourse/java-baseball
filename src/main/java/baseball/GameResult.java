package baseball;

import java.util.List;

public class GameResult {
  private int strikeCount;
  private int ballCount;

  public void setResultByGameNumber(GameNumber answerNumber, GameNumber gameNumber) {
    List<Integer> answerNumberList = answerNumber.getGameNumberList();
    List<Integer> gameNumberList = gameNumber.getGameNumberList();
    strikeCount = 0;
    ballCount = 0;
    calculateResult(answerNumberList, gameNumberList);
  }

  public String getResultString(){
    if (strikeCount + ballCount == 0) return "낫싱";
    return getBallString() + getStrikeString();
  }

  private String getStrikeString(){
    if (strikeCount != 0) return strikeCount + "스트라이크";
    else return "";
  }

  private String getBallString(){
    if (ballCount != 0) return ballCount + "볼 ";
    else return "";
  }

  public boolean isAnswer() {
    return strikeCount == GameNumber.NUMBER_DIGIT;
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
