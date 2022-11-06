package baseball.io;

import java.util.HashSet;
import java.util.Set;

public class PlayingInputValidator implements InputValidator{

  @Override
  public void validate(String input) {
    checkLength(input);
  }

  private void checkLength(String input) {
    if(input.length() != 3) throw new IllegalArgumentException();
  }
}
