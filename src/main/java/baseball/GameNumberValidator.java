package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameNumberValidator {
  public static int checkIsInt(char inputChar) {
    int gameNumber = 0;
    try {
      gameNumber = Integer.parseInt(String.valueOf(inputChar));
    } catch (NumberFormatException e) {
      throwIllegalArgumentExceptionWithMessage("숫자가 아닙니다!");
    }
    return gameNumber;
  }

  public static void checkNumbersValid(List<Integer> gameNumberList) {
    if (gameNumberList.size() != GameNumber.NUMBER_DIGIT)
      throwIllegalArgumentExceptionWithMessage("자리수가 잘못되었습니다!");
    checkDifferentNumbers(gameNumberList);
    checkIncludeZero(gameNumberList);
  }

  private static void checkDifferentNumbers(List<Integer> gameNumberList) {
    Set<Integer> gameNumberSet = new HashSet<>(gameNumberList);
    if (gameNumberSet.size() != gameNumberList.size())
      throwIllegalArgumentExceptionWithMessage("중복되는 숫자가 있습니다!");
  }

  private static void checkIncludeZero(List<Integer> gameNumberList) {
    for (int i : gameNumberList) {
      if (i == 0) throwIllegalArgumentExceptionWithMessage("0이 포함되어 있습니다!");
    }
  }

  private static void throwIllegalArgumentExceptionWithMessage(String message)
      throws IllegalArgumentException {
    System.out.println(message);
    throw new IllegalArgumentException(message);
  }
}
