package baseball.io;

import java.util.HashSet;
import java.util.Set;

public class PlayingInputValidator implements InputValidator{

  @Override
  public void validate(String input) {
    checkLength(input);
    checkEachDigit(input);
  }

  private void checkLength(String input) {
    if(input.length() != 3) throw new IllegalArgumentException();
  }

  private void checkEachDigit(String input) {
    for (int i = 0; i < input.length(); i++) {
      isDigitBetween1to9(input.charAt(i));
    }
    isAllUniqueDigit(input);
  }

  private void isDigitBetween1to9(char c) {
    if(!Character.isDigit(c)) throw new IllegalArgumentException();
  }

  private void isAllUniqueDigit(String input) {
    Set<Character> set = new HashSet();
    for (char c : input.toCharArray()) {
      set.add(c);
    }
    if(set.size() != input.length()) throw new IllegalArgumentException();
  }
}
