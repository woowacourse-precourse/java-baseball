package baseball;

import org.junit.jupiter.api.Test;

import org.assertj.core.api.Assertions;
// 올바르지 않은 입력값이면 throw를 하고 있는지
class InputValidatorTest {
  //길이에 대한 검사
  @Test
  void isRightLength() {
    String longeNumber = "1234";
    String shortNumber = "1";
    String notDigit = "abcd";
    Assertions.assertThatThrownBy(() -> InputValidator.isRightLength(longeNumber))
            .isInstanceOf(IllegalArgumentException.class);
    Assertions.assertThatThrownBy(() -> InputValidator.isRightLength(shortNumber))
            .isInstanceOf(IllegalArgumentException.class);
    Assertions.assertThatThrownBy(() -> InputValidator.isRightLength(notDigit))
            .isInstanceOf(IllegalArgumentException.class);
  }

// 중복 검사
  @Test
  void isDuplicated() {
    String duplicatedNumber = "122";
    String duplicatedAndShort = "99";
    String duplicatedAndLong = "1334";
    Assertions.assertThatThrownBy(() -> InputValidator.isDuplicated(duplicatedNumber))
            .isInstanceOf(IllegalArgumentException.class);
    Assertions.assertThatThrownBy(() -> InputValidator.isDuplicated(duplicatedAndShort))
            .isInstanceOf(IllegalArgumentException.class);
    Assertions.assertThatThrownBy(() -> InputValidator.isDuplicated(duplicatedAndLong))
            .isInstanceOf(IllegalArgumentException.class);
  }

  //숫자만 들어있는지
  @Test
  void isNumber() {
    String shortAndNotDigit = "a";
    String longAndNotDigit = "abcd";
    Assertions.assertThatThrownBy(() -> InputValidator.isNumber(shortAndNotDigit))
            .isInstanceOf(IllegalArgumentException.class);
    Assertions.assertThatThrownBy(() -> InputValidator.isNumber(longAndNotDigit))
            .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void isValidNumber() {
    String testCase1 = "112";
    String testCase2 = "0";
    String testCase3 = "9a";
    String testCase4 = "092";
    String testCase5 = "9A1";
    Assertions.assertThatThrownBy(() -> InputValidator.isValidNumber(testCase1))
            .isInstanceOf(IllegalArgumentException.class);
    Assertions.assertThatThrownBy(() -> InputValidator.isValidNumber(testCase2))
            .isInstanceOf(IllegalArgumentException.class);
    Assertions.assertThatThrownBy(() -> InputValidator.isValidNumber(testCase3))
            .isInstanceOf(IllegalArgumentException.class);
    Assertions.assertThatThrownBy(() -> InputValidator.isValidNumber(testCase4))
            .isInstanceOf(IllegalArgumentException.class);
    Assertions.assertThatThrownBy(() -> InputValidator.isValidNumber(testCase5))
            .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void isValidButton() {
    Assertions.assertThatThrownBy(() -> InputValidator.isValidButton("a"))
            .isInstanceOf(IllegalArgumentException.class);
  }
}