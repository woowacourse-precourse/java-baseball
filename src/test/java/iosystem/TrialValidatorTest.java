package iosystem;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.junit.jupiter.api.Assertions.*;

class TrialValidatorTest {

    @Test
    @DisplayName("정상적인 값 입력")
    void success() {
        // given
        String correctInput;
        correctInput = "123";

        //when, then
        assertDoesNotThrow(()-> TrialValidator.validate(correctInput));
    }

    @Test
    @DisplayName("0이 포함된 입력")
    void inputThreeNumberWithZeroTest() {
        // given
        String inputThreeNumberWithZero = "120";

        // when
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> TrialValidator.validate(inputThreeNumberWithZero));

        // then
        assertEquals("1~9사이의 숫자로만 이루어진 수를 입력할 수 있습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("문자가 포함된 입력")
    void inputWithCharacterTest() {
        // given
        String inputWithCharacter = "12a";

        // when
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> TrialValidator.validate(inputWithCharacter));

        // then
        assertEquals("1~9사이의 숫자로만 이루어진 수를 입력할 수 있습니다.", exception.getMessage());
    }
    @Test
    @DisplayName("4자리 숫자 입력")
    void inputFourNumberTest() {
        // given
        String inputFourNumber = "1234";

        // when
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> TrialValidator.validate(inputFourNumber));

        // then
        assertEquals("3자리 수만 입력할 수 있습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("중복되는 숫자 입력")
    void inputDuplicatedNumberTest() {
        // given
        String inputDuplicatedNumber = "133";

        // when
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> TrialValidator.validate(inputDuplicatedNumber));

        // then
        assertEquals("자리수 간 중복된 수를 가질 수 없습니다.", exception.getMessage());
    }

    @ParameterizedTest(name = "{displayName} => {0}")
    @DisplayName("예외 처리: null 입력")
    @NullAndEmptySource
    void inputNullNumberTest(String input) {
        //todo
    }
}