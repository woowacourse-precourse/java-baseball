package baseball;

import baseball.constant.ExceptionMessages;
import baseball.io.InputValidator;
import baseball.io.PlayingInputValidator;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

  @Test
  void 입력값의_길이가_3이_아닐때_예외를_던지는가_1() {
    try {
      InputValidator validator = new PlayingInputValidator();
      String userInput = "12";
      validator.validate(userInput);
    } catch (IllegalArgumentException e) {
      assertEquals(ExceptionMessages.INPUT_LENGTH_IS_NOT_THREE.getExceptionMessage(), e.getMessage());
    }
  }

  @Test
  void 입력값의_길이가_3이_아닐때_예외를_던지는가_2() {
    try {
      InputValidator validator = new PlayingInputValidator();
      String userInput = "1234";
      validator.validate(userInput);
    } catch (IllegalArgumentException e) {
      assertEquals(ExceptionMessages.INPUT_LENGTH_IS_NOT_THREE.getExceptionMessage(), e.getMessage());
    }
  }

  @Test
  void 입력값에_0이_포함되어_있으면_예외를_던지는가() {
    try {
      InputValidator validator = new PlayingInputValidator();
      String userInput = "120";
      validator.validate(userInput);
    } catch (IllegalArgumentException e) {
      assertEquals(ExceptionMessages.INPUT_IS_NOT_DIGIT.getExceptionMessage(), e.getMessage());
    }
  }

  @Test
  void 입력값이_숫자가_아닌_경우_예외를_던지는가() {
    try {
      InputValidator validator = new PlayingInputValidator();
      String userInput = "가나다";
      validator.validate(userInput);
    } catch (IllegalArgumentException e) {
      assertEquals(ExceptionMessages.INPUT_IS_NOT_DIGIT.getExceptionMessage(), e.getMessage());
    }
  }

  private InputStream readUserInput(String input) {
    return new ByteArrayInputStream(input.getBytes());
  }

  @Test
  void 유저가_게임_재시작을_위해_1을_입력한_경우_정상적으로_동작하는가() {

    // given
    GameController controller = new GameController();
    InputStream inputStream = readUserInput("1");
    System.setIn(inputStream);

    // when
    boolean isItRestartInput = controller.checkRestart();

    // then
    assertEquals(true, isItRestartInput);

  }
}
