package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameNumber {
  public static final int NUMBER_DIGIT = 3;
  private List<Integer> gameNumberList = new ArrayList<>();

  public void stringToGameNumber(String inputString) {
    List<Integer> numbers = new ArrayList<>();
    for (char s : inputString.toCharArray()) numbers.add(charToInt(s));
    setGameNumberByList(numbers);
  }

  public void setGameNumberByList(List<Integer> numberList) {
    for (int i : numberList) gameNumberList.add(i);
    checkNumbersValid();
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
    if (gameNumberList.size() != NUMBER_DIGIT)
      throwIllegalArgumentExceptionWithMessage("자리수가 잘못되었습니다!");
    checkDifferentNumbers();
    checkIncludeZero();
  }

  private void checkDifferentNumbers() {
    Set<Integer> gameNumberSet = new HashSet<>(gameNumberList);
    if (gameNumberSet.size() != gameNumberList.size())
      throwIllegalArgumentExceptionWithMessage("중복되는 숫자가 있습니다!");
  }

  private void checkIncludeZero() {
    for (int i : gameNumberList) {
      if (i == 0) throwIllegalArgumentExceptionWithMessage("0이 포함되어 있습니다!");
    }
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
