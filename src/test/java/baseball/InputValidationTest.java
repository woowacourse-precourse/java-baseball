package baseball;

import baseball.io.InputValidator;
import baseball.io.PlayingInputValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputValidationTest {

  @Test
  void 입력값에_중복되는_수가_들어있는_경우_예외를_던지는가() {
    try {
      InputValidator validator = new PlayingInputValidator();
      String userInput = "112";
      validator.validate(userInput);
    } catch (IllegalArgumentException e) {
      assertEquals(ExceptionMessages.INPUT_IS_NOT_UNIQUE.getExceptionMessage(), e.getMessage());
    }
  }
}
