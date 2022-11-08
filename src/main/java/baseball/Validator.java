package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.constants.Exception.*;


public class Validator {

  public void validate(List<Integer> numbers) {

    if (!checkLength(numbers)) {
      throw new IllegalArgumentException(INVALID_INPUT_LENGTH_ERROR);
    }

    if (!isBetween(numbers)) {
      throw new IllegalArgumentException(OUT_OF_RANGE_INPUT_ERROR);
    }

    if (isDuplicated(numbers)) {
      throw new IllegalArgumentException(DUPLICATED_INPUT_ERROR);
    }

  }

  public boolean checkLength(List<Integer> numbers) {
    return numbers.size() == 3;
  }

  public boolean isBetween(List<Integer> numbers) {
    for (int number : numbers) {
      return number >= 1 && number <= 9;
    }
    return false;
  }

  public boolean isDuplicated(List<Integer> numbers) {
    Set<Integer> set = new HashSet<>(numbers);
    return set.size() != numbers.size();
  }
}
