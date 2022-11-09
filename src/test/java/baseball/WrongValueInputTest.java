package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class WrongValueInputTest {
  @DisplayName("문자열 입력시 예외 발생")
  @ParameterizedTest(name ="{index} {displayName} message={0} ")
  @ValueSource(strings = {"가나다", "hello"})
  void canNotInputString(String input) {
    checkWrongValueInput(input);
  }

  @DisplayName("잘못된 자리수 입력시 예외 발생")
  @ParameterizedTest(name ="{index} {displayName} message={0} ")
  @ValueSource(strings = {"1234", "1"})
  void canNotInputWrongDigit(String input) {
    checkWrongValueInput(input);
  }

  @DisplayName("범위를 벗어나는 수 입력시 예외 발생")
  @ParameterizedTest(name ="{index} {displayName} message={0} ")
  @ValueSource(strings = {"102", "013", "120"})
  void canNotInputOutOfRange(String input) {
    checkWrongValueInput(input);
  }

  @DisplayName("중복되는 숫자 입력시 예외 발생")
  @ParameterizedTest(name ="{index} {displayName} message={0} ")
  @ValueSource(strings = {"121", "211", "112"})
  void canNotInputDuplicateNumber(String input) {
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
