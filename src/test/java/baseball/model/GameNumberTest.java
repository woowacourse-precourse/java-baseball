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
        void InvalidGameNumberSize(String numbers) {
            assertThrows(IllegalArgumentException.class, () ->
                    new GameNumber(numbers));
        }
    }

}