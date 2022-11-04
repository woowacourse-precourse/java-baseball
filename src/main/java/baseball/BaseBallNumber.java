package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseBallNumber {

  public static final int GAME_NUMBER_SIZE = 3;

  private static List<Character> numbers;

  public BaseBallNumber(List<Character> numbers) {
    validateSize(numbers);
    validateDuplicate(numbers);
    BaseBallNumber.numbers = numbers;
  }

  public static void validateSize(List<Character> numbers) {
    if (numbers.size() != 3) {
      throw new IllegalArgumentException("Baseball number length should be " + GAME_NUMBER_SIZE);
    }
  }

  public static void validateDuplicate(List<Character> numbers) {
    Set<Character> number = new HashSet<>(numbers);
    if (number.size() != numbers.size()) {
      throw new IllegalArgumentException("Baseball number has duplicate number.");
    }
  }
}
