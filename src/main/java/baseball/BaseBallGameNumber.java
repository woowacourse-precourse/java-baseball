package baseball;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGameNumber {

  private List<Integer> gameNumberList = new ArrayList<>();

  public void stringToGameNumber(String inputString) {
    if(inputString.length() != 3) throw new IllegalArgumentException("세자리가 아닙니다!");
    int gameNumber = stringToInt(inputString);
    setBaseBallGameNum(gameNumber);
  }

  private int stringToInt(String inputString) {
    try {
      return Integer.parseInt(inputString);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("숫자가 아닙니다!");
    }
  }

  private void setBaseBallGameNum(int gameNumber) {
    gameNumberList.add(0, gameNumber / 100);
    gameNumberList.add(1, gameNumber % 100 / 10);
    gameNumberList.add(2, gameNumber % 10);
  }
}
