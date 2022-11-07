package baseball;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
// 올바르지 않은 입력값이면 throw를 하고 있는지
class InputValidatorTest {
  //길이에 대한 검사
  @Test
  void isRightLength() {
    assertThatThrownBy(() -> InputValidator.isRightLength("1234"))
            .isInstanceOf(IllegalArgumentException.class);
  }

// 중복 검사
  @Test
  void isDuplicated() {
    assertThatThrownBy(() -> InputValidator.isDuplicated("122"))
            .isInstanceOf(IllegalArgumentException.class);
  }

  //숫자만 들어있는지
  @Test
  void isNumber() {
    assertThatThrownBy(() -> InputValidator.isNumber("a24"))
            .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void isValidNumber() {

  }

  @Test
  void isValidButton() {
  }
}