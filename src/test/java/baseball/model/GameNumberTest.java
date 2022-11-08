package baseball.model;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("게임 숫자 생성 테스트")
class GameNumberTest {

    @DisplayName("숫자가 아니면 예외가 발생한다.")
    @Test
    public void validGameNumberInteger() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> GameNumber.from("abc"));
    }

    @Nested
    @DisplayName("게임 숫자 사이즈")
    @TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
    class GameNumberSizeTest {
        @Order(1)
        @DisplayName("숫자가 3개면 정상적으로 생성된다.")
        @Test
        void validGameNumberSize() {
            assertDoesNotThrow(() -> GameNumber.from("123"));
        }


        @Order(2)
        @DisplayName("숫자가 3개가 아니면 예외가 발생한다.")
        @ParameterizedTest(name = "{index}. 예외 발생 입력값 = {0}")
        @ValueSource(strings = {"1", "12", "1234"})
        void invalidGameNumberSize(String input) {
            assertThrows(IllegalArgumentException.class, () -> GameNumber.from(input));
        }
    }

    @Nested
    @DisplayName("게임 숫자 범위")
    @TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
    class GameNumberRangeTest {

        @Order(1)
        @DisplayName("숫자가 1~9 범위면 정상적으로 생성된다.")
        @Test
        void validGameNumberRange() {
            assertDoesNotThrow(() -> GameNumber.from("123"));
        }

        @DisplayName("숫자가 1~9 범위를 벗어나면 예외가 발생한다.")
        @Test
        void invalidGameNumberRange() {
            assertThrows(IllegalArgumentException.class, () -> GameNumber.from("012"));
        }
    }

    @DisplayName("게임 숫자 중복")
    @Nested
    @TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
    class GameNumberDuplicateTest {
        @Order(1)
        @DisplayName("숫자가 중복되지 않으면 정상적으로 생성된다.")
        @Test
        void gameNumberNonDuplicate() {
            assertDoesNotThrow(() -> GameNumber.from("123"));
        }

        @Order(2)
        @DisplayName("숫자중 중복되는 숫자가 있으면 예외가 발생한다.")
        @Test
        void gameNumberDuplicate() {
            assertThrows(IllegalArgumentException.class, () -> GameNumber.from("122"));
        }
    }
}