package baseball;

import baseball.input.InputReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {

  private final InputReader inputReader;

  public Player(InputReader inputReader) {
    this.inputReader = inputReader;
  }

  public List<Integer> guessNumber() {
    String inputNumber = inputReader.readLine();
    validateInputNumber(inputNumber);
    return convertToImmutableIntegerList(inputNumber);
  }

  private List<Integer> convertToImmutableIntegerList(String from) {
    List<Integer> result = new ArrayList<>();
    for (char fromCh : from.toCharArray()) {
      result.add(fromCh - '0');
    }
    return Collections.unmodifiableList(result);
  }

  private void validateInputNumber(String inputNumber) {
    if (inputNumber.length() != 3) {
      throw new IllegalArgumentException("입력값은 3자리여야 합니다.");
    }
    for (char inputCh : inputNumber.toCharArray()) {
      if (!Character.isDigit(inputCh)) {
        throw new IllegalArgumentException("숫자만 입력가능합니다.");
      }
      if (inputCh == '0') {
        throw new IllegalArgumentException("입력값에 0은 포함될 수 없습니다.");
      }
    }
    if (checkDuplicatedDigit(inputNumber)) {
      throw new IllegalArgumentException("중복되는 숫자가 존재하면 안됩니다.");
    }
  }

  private boolean checkDuplicatedDigit(String input) {
    return input.charAt(0) == input.charAt(1) ||
            input.charAt(1) == input.charAt(2) ||
            input.charAt(0) == input.charAt(2);
  }
}
