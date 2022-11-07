package baseball.dto;

public class InputSignal {

  private final Integer signal;

  public Integer getSignal() {
    return this.signal;
  }

  public InputSignal(String input) {
    validateNumericAndLength(input);
    this.signal = Integer.parseInt(input);
  }

  private void validateNumericAndLength(String str) {
    boolean checkValue = str != null && str.matches("[1-2]");
    if (!checkValue) {
      throw new IllegalArgumentException();
    }
  }
}
