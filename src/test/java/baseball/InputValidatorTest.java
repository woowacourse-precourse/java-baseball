package baseball;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class InputValidatorTest {
  // 올바르지 않은 길이면 throw를 하고 있는가
  @Test
  void isRightLength() {
    assertThatThrownBy(() -> InputValidator.isRightLength("1234"))
            .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void isDuplicated() {
  }

  @Test
  void isNumber() {
  }

  @Test
  void isValidNumber() {
  }

  @Test
  void isValidButton() {
  }
}