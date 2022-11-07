package baseball;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGameNumber {

  private List<Integer> gameNumberList = new ArrayList<>();

  public void stringToGameNumber(String inputString) {
    if(inputString.length() != 3) throw new IllegalArgumentException("세자리가 아닙니다!");
    int gameNumber = stringToInt(inputString);
    setBaseBallGameNum(gameNumber);
    checkNumbersValid();
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

  private void checkNumbersValid() {
    checkDifferentNumbers();
    checkIncludeZero();
  }

  private void checkDifferentNumbers() {
    for (int i = 1; i < gameNumberList.size(); i++) {
      if (gameNumberList.get(i) == gameNumberList.get(i - 1))
        throw new IllegalArgumentException("중복되는 숫자가 있습니다.");
    }
  }

  private void checkIncludeZero() {
    if (gameNumberList.get(0) * gameNumberList.get(1) * gameNumberList.get(2) == 0)
      throw new IllegalArgumentException("0이 포함되어 있습니다.");
  }
}
