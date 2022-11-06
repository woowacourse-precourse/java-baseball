package baseball.io;

public class ReplayOrEndInputValidator implements InputValidator{

  @Override
  public void validate(String input) {
    checkDigit(input);
  }

  private void checkDigit(String input) {
    if (!input.equals("1") && !input.equals("2")) {
      throw new IllegalArgumentException();
    }
  }
}
