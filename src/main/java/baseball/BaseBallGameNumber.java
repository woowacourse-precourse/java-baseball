package baseball;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGameNumber {

  private List<Integer> gameNumberList = new ArrayList<>();

  public void stringToGameNumber(String inputString) {
    if (inputString.length() != 3) throwIllegalArgumentExceptionWithMessage("세자리가 아닙니다!");
    int gameNumber = stringToInt(inputString);
    setBaseBallGameNum(gameNumber);
    checkNumbersValid();
  }

  public void setGameNumberByList(List<Integer> numberList) {
    gameNumberList.add(numberList.get(0));
    gameNumberList.add(numberList.get(1));
    gameNumberList.add(numberList.get(2));
  }

  private int stringToInt(String inputString) {
    int gameNumber = 0;
    try {
      gameNumber = Integer.parseInt(inputString);
    } catch (NumberFormatException e) {
      throwIllegalArgumentExceptionWithMessage("숫자가 아닙니다!");
    }
    return gameNumber;
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
    if (gameNumberList.get(0) == gameNumberList.get(1)
        || gameNumberList.get(1) == gameNumberList.get(2)
        || gameNumberList.get(0) == gameNumberList.get(2))
      throwIllegalArgumentExceptionWithMessage("중복되는 숫자가 있습니다.");
  }

  private void checkIncludeZero() {
    if (gameNumberList.get(0) * gameNumberList.get(1) * gameNumberList.get(2) == 0)
      throwIllegalArgumentExceptionWithMessage("0이 포함되어 있습니다.");
  }

  public void printNumbers() {
    String outputString = "";
    for (int n : gameNumberList) {
      outputString += n + " ";
    }
    System.out.println(outputString);
  }

  public List<Integer> getGameNumberList() {
    return this.gameNumberList;
  }

  private void throwIllegalArgumentExceptionWithMessage(String message)
      throws IllegalArgumentException {
    System.out.println(message);
    throw new IllegalArgumentException(message);
  }

  public BaseBallGameNumber() {}
}
