package baseball.model;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class GameNumberTest {

    @Nested
    @DisplayName("게임 숫자 사이즈 테스트")
    @TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
    class GameNumberSizeTest {
        @Order(1)
        @DisplayName("게임 숫자가 3자리면 정상적으로 생성된다.")
        @Test
        void validGameNumberSize() {
            assertDoesNotThrow(() -> new GameNumber("123"));
        }

        @Order(2)
        @DisplayName("게임 숫자가 3개가 아니면 예외가 발생한다.")
        @ParameterizedTest(name = "{index}. 예외 발생 입력값 = {0}")
        @ValueSource(strings = {"1", "12", "1234"})
        void invalidGameNumberSize(String numbers) {
            assertThrows(IllegalArgumentException.class, () ->
                    new GameNumber(numbers));
        }
    }

    @Nested
    @DisplayName("게임 숫자 범위 테스트")
    @TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
    class GameNumberRangeTest {

        @DisplayName("1~9 범위 내의 숫자 입력시 정상적으로 생성된다.")
        @Test
        void validGameNumberRange() {
            assertDoesNotThrow(() -> new GameNumber("123"));
        }

        @DisplayName("1~9 범위를 벗어난 숫자 입력시 예외가 발생한다.")
        @Test
        void invalidGameNumberRange() {
            assertThrows(IllegalArgumentException.class, () -> new GameNumber("012"));
        }
    }
}