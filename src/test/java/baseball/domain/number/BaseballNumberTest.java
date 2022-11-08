package baseball.domain.number;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static baseball.domain.number.Number.NUMBER_ERROR_MESSAGE;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BaseballNumberTest {

  private static Integer number;

  @BeforeAll()
  static void number_test_init() {
    Number numberInstance = new Number();
    number = numberInstance.getNumber();
  }

  @Test
  @DisplayName("컴퓨터가 생성하는 각 자리 숫자는 1에서 9사이의 숫자입니다.")
  @Tag("number")
  void number_between_1_and_9() {
    assertTrue(1 <= number && number <= 9, () -> NUMBER_ERROR_MESSAGE);
  }

  @DisplayName("1에서 9사이의 숫자가 아닐 때 에러가 발생합니다.")
  @ParameterizedTest(name = "[{index}] number={0}")
  @ValueSource(ints = { -1, 0, 10, 11 })
  @Tag("number")
  void create_number_error(int exceptionNumber) {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Number(exceptionNumber));
    assertEquals(NUMBER_ERROR_MESSAGE, exception.getMessage());
  }
}