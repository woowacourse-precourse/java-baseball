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

  public String getResultString() {
    if (strikeCount + ballCount == 0) return ResultMessage.NOTHING.getMessage();
    return getBallString() + getStrikeString();
  }

  private String getStrikeString() {
    if (strikeCount != 0) return ResultMessage.STRIKE.getMessage(strikeCount);
    else return "";
  }

  private String getBallString() {
    if (ballCount != 0) return ResultMessage.BALL.getMessage(ballCount);
    else return "";
  }

  public boolean isAnswer() {
    return strikeCount == GameNumber.NUMBER_DIGIT;
  }

  private void calculateResult(List<Integer> answerNumberList, List<Integer> gameNumberList) {
    // 각 자리수를 비교해서 순서와 숫자가 같으면 Strike, 숫자만 같으면 Ball 증가
    for (int i = 0; i < answerNumberList.size(); i++) {
      for (int j = 0; j < gameNumberList.size(); j++) {
        boolean isUpdated = updateCount(isSame(answerNumberList.get(i), gameNumberList.get(j)), isSame(i, j));
        if (isUpdated) break;
      }
    }
  }

  private boolean isSame(int num1, int num2){
    return num1 == num2;
  }

  private boolean updateCount(boolean isSameNumber, boolean isSameIndex) {
    if(isSameNumber){
      if (isSameIndex) strikeCount++;
      else ballCount++;
      return true;
    }
    return false;
  }
}
