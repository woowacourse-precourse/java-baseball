package baseball;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class WrongValueInputTest {
  @ParameterizedTest
  @ValueSource(strings = {"가나다", "hello"})
  void 문자열입력시_예외발생(String input) {
    checkWrongValueInput(input);
  }

  @ParameterizedTest
  @ValueSource(strings = {"1234", "1"})
  void 잘못된_자리수_입력시_예외발생(String input) {
    checkWrongValueInput(input);
  }

  @ParameterizedTest
  @ValueSource(strings = {"102", "013", "120"})
  void 범위를_벗어나는_수_입력시_예외발생(String input) {
    checkWrongValueInput(input);
  }

  @ParameterizedTest
  @ValueSource(strings = {"121", "211", "112"})
  void 중복되는_숫자_입력시_예외발생(String input) {
    checkWrongValueInput(input);
  }

  private void checkWrongValueInput(String inputString) {
    GameNumber gameNumber = new GameNumber();
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          gameNumber.setGameNumberByString(inputString);
        });
  }
}
