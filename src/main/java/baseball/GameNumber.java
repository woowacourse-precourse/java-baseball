package baseball;

import java.util.ArrayList;
import java.util.List;

public class GameNumber {
  private List<Integer> gameNumberList = new ArrayList<>();

  public void stringToGameNumber(String inputString) {
    if (inputString.length() != 3)
      throwIllegalArgumentExceptionWithMessage("세 자리수가 아닙니다!");
    List<Integer> numbers = new ArrayList<>();
    for (char s : inputString.toCharArray()) {
      numbers.add(charToInt(s));
    }
    setGameNumberByList(numbers);
    checkNumbersValid();
  }

  public void setGameNumberByList(List<Integer> numberList) {
    gameNumberList.add(numberList.get(0));
    gameNumberList.add(numberList.get(1));
    gameNumberList.add(numberList.get(2));
  }

  private int charToInt(char inputChar) {
    int gameNumber = 0;
    try {
      gameNumber = Integer.parseInt(String.valueOf(inputChar));
    } catch (NumberFormatException e) {
      throwIllegalArgumentExceptionWithMessage("숫자가 아닙니다!");
    }
    return gameNumber;
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

  public List<Integer> getGameNumberList() {
    return this.gameNumberList;
  }

  private void throwIllegalArgumentExceptionWithMessage(String message)
      throws IllegalArgumentException {
    System.out.println(message);
    throw new IllegalArgumentException(message);
  }
}
