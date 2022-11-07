package baseball.io;

import baseball.constant.ExceptionMessages;

public class ReplayOrEndInputValidator implements InputValidator{

  @Override
  public void validate(String input) {
    checkDigit(input);
  }

  private void checkDigit(String input) {
    if (!input.equals("1") && !input.equals("2")) {
      throw new IllegalArgumentException(ExceptionMessages.INPUT_IS_NOT_1_OR_2.getExceptionMessage());
    }
  }
}
