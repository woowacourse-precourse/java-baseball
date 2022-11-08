package baseball.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exception {

  private static final int MAX_NUMBER_SIZE = 3;
  private static final String RESTART_NUMBER = "1";
  private static final String EXIT_NUMBER = "2";

  public boolean isValidMyInput(String inputNumberString) {
    if (!isValidLength(inputNumberString)) {
      throw new IllegalArgumentException();
    }
    if (!isNumeric(inputNumberString)) {
      throw new IllegalArgumentException();
    }
    if (!isAnotherNumber(inputNumberString)) {
      throw new IllegalArgumentException();
    }
    return true;
  }

  private boolean isValidLength(String inputNumberString) {
    if (inputNumberString.length() == MAX_NUMBER_SIZE) {
      return true;
    }
    return false;
  }

  private boolean isNumeric(String inputNumberString) {
    try {
      Double.parseDouble(inputNumberString);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  private boolean isAnotherNumber(String inputNumberString) {
    List<Character> inputNumberStringList = new ArrayList<>();
    for (char number : inputNumberString.toCharArray()) {
      inputNumberStringList.add(number);
    }
    Set<Character> inputNumberStringSet = new HashSet<>(inputNumberStringList);
    if (inputNumberStringList.size() != inputNumberStringSet.size()) {
      return false;
    }
    return true;
  }

  public boolean isValidRestartOrExitNumber(String restartOrExitNumber) {
    if (restartOrExitNumber.equals(RESTART_NUMBER)) {
      return true;
    }
    if (restartOrExitNumber.equals(EXIT_NUMBER)) {
      return false;
    }
    throw new IllegalArgumentException();
  }
}
