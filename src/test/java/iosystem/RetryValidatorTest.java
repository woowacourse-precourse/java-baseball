package iosystem;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class RetryValidatorTest {

    @Test
    @DisplayName("정상적인 값 입력")
    void success() {
        String correctInput= "1";
        assertDoesNotThrow(()-> RetryValidator.validate(correctInput));
    }

    @Test
    @DisplayName("숫자 외 문자 입력")
    void retryValidatorTest() {
        // given
        String inputWithCharacter = "a";

        // when
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> RetryValidator.validate(inputWithCharacter));

        // then
        assertEquals("1~2사이의 1자리 수만 입력할 수 있습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("1,2외의 숫자 0 입력")
    void inputNumberZeroTest() {
        // given
        String inputNumberZero = "0";

        // when
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> RetryValidator.validate(inputNumberZero));

        // then
        assertEquals("1~2사이의 1자리 수만 입력할 수 있습니다.", exception.getMessage());
    }
}