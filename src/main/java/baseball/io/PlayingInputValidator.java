package baseball.io;

import baseball.constant.ExceptionMessages;

import java.util.HashSet;
import java.util.Set;

public class PlayingInputValidator implements InputValidator{

  @Override
  public void validate(String input) {
    checkLength(input);
    checkEachDigit(input);
  }

  private void checkLength(String input) {
    if(input.length() != 3) throw new IllegalArgumentException(ExceptionMessages.INPUT_LENGTH_IS_NOT_THREE.getExceptionMessage());
  }

  private void checkEachDigit(String input) {
    for (int i = 0; i < input.length(); i++) {
      isDigitBetween1to9(input.charAt(i));
    }
    isAllUniqueDigit(input);
  }

  private void isDigitBetween1to9(char c) {
    // digit(0~9)이 아니거나, 0을 포함하는 경우 예외를 던짐
    if(!Character.isDigit(c) || c == 48) throw new IllegalArgumentException(ExceptionMessages.INPUT_IS_NOT_DIGIT.getExceptionMessage());
  }

  private void isAllUniqueDigit(String input) {
    Set<Character> set = new HashSet();
    for (char c : input.toCharArray()) {
      set.add(c);
    }
    if(set.size() != input.length()) throw new IllegalArgumentException(ExceptionMessages.INPUT_IS_NOT_UNIQUE.getExceptionMessage());
  }
}
