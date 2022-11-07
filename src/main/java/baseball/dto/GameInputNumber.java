package baseball.dto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameInputNumber {

  private final List<Integer> numbers;

  public List<Integer> getNumbers() {
    return this.numbers;
  }

  public GameInputNumber(String input) {
    validateLengthAndIsNumeric(input);
    List<Integer> integers = convertToIntegerArray(input);
    validateListLength(integers);
    this.numbers = integers;
  }

  private void validateLengthAndIsNumeric(String str) {
    boolean checkValue = str != null && str.matches("[1-9]{3}");
    if (!checkValue) {
      throw new IllegalArgumentException();
    }
  }

  private void validateListLength(List<Integer> integers) {
    if (integers.size() != 3) {
      throw new IllegalArgumentException();
    }
  }

  private List<Integer> convertToIntegerArray(String str) {
    return Arrays.stream(str.split(""))
        .map(Integer::parseInt)
        .distinct().collect(Collectors.toList());
  }
}
