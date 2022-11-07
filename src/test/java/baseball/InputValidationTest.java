package baseball;

import baseball.constant.ExceptionMessages;
import baseball.io.InputValidator;
import baseball.io.PlayingInputValidator;
import org.assertj.core.util.Streams;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

public class InputValidationTest {

  @ParameterizedTest
  @CsvSource(value = {"1,true","2,false"})
  void 유저가_게임_재시작_및_종료를_위해_1_또는_2를_입력한_경우_정상적으로_동작하는가(String userInput, boolean expectedBoolean) {

    // given
    GameController controller = new GameController();
    InputStream inputStream = readUserInput(userInput);
    System.setIn(inputStream);

    // when
    boolean isItRestartInput = controller.checkRestart();

    // then
    assertEquals(expectedBoolean, isItRestartInput);
  }

  @ParameterizedTest
  @MethodSource("provideExpectedInputAndActualErrorMessage")
  void 플레이어가_입력한_3자리_숫자가_잘못된_값인_경우_특정_메시지를_포함한_예외를_던지는가(String input, String actualErrorMessage) {
    try {
      InputValidator validator = new PlayingInputValidator();
      String userInput = input;
      validator.validate(userInput);
    } catch (IllegalArgumentException e) {
      assertEquals(actualErrorMessage, e.getMessage());
    }
  }

  static Stream<Arguments> provideExpectedInputAndActualErrorMessage() {
    return Stream.of(
      Arguments.of("112", ExceptionMessages.INPUT_IS_NOT_UNIQUE.getExceptionMessage()),
      Arguments.of("12", ExceptionMessages.INPUT_LENGTH_IS_NOT_THREE.getExceptionMessage()),
      Arguments.of("1234", ExceptionMessages.INPUT_LENGTH_IS_NOT_THREE.getExceptionMessage()),
      Arguments.of("120", ExceptionMessages.INPUT_IS_NOT_DIGIT.getExceptionMessage()),
      Arguments.of("가나다", ExceptionMessages.INPUT_IS_NOT_DIGIT.getExceptionMessage())
    );
  }

  private InputStream readUserInput(String input) {
    return new ByteArrayInputStream(input.getBytes());
  }

}
