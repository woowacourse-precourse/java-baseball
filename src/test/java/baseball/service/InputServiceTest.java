package baseball.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputServiceTest {

  private final InputService inputService = new InputService();

  @Test
  @DisplayName("정해진 길이의 입력이 아니면 false 를 반환한다.")
  void isInvalidLength() {
    // given
    String number = "123";

    // when
    boolean result = inputService.isInValidLength(number);

    // then
    assertThat(result).isFalse();
  }

  @Test
  @DisplayName("중복된 숫자가 입력되면 false 를 반환한다.")
  void hasDuplicateNumbers() {
    // given
    String number = "223";

    // when
    boolean result = inputService.isInValidLength(number);

    // then
    assertThat(result).isFalse();
  }

  @Test
  @DisplayName("주어진 범위를 넘어선 수가 존재하면 false 를 반환한다.")
  void hasInvalidRange1() {
    // given
    String number = "203";

    // when
    boolean result = inputService.isInValidLength(number);

    // then
    assertThat(result).isFalse();
  }

  @Test
  @DisplayName("주어진 범위를 넘어선 문자가 존재하면 false 를 반환한다.")
  void hasInvalidRange2() {
    // given
    String number = "2가3";

    // when
    boolean result = inputService.isInValidLength(number);

    // then
    assertThat(result).isFalse();
  }

  @Test
  @DisplayName("시작 1, 재시작 2 외의 입력이 들어오면 예외처리")
  void checkGameStatus() {
    // given
    String status = "3";

    // then
    assertThatThrownBy(() -> inputService.checkGameStatus(status))
        .isInstanceOf(IllegalArgumentException.class);
  }

}