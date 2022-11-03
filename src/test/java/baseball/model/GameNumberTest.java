package baseball.model;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("게임 숫자 생성 테스트")
class GameNumberTest {

    @Nested
    @DisplayName("게임 숫자 사이즈")
    @TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
    class GameNumberSizeTest {
        @Order(1)
        @DisplayName("숫자가 3개면 정상적으로 생성된다.")
        @Test
        void validGameNumberSize() {
            List<Integer> numbers = createNumbers("123");

            assertDoesNotThrow(() -> new GameNumber(numbers));
        }


        @Order(2)
        @DisplayName("숫자가 3개가 아니면 예외가 발생한다.")
        @ParameterizedTest(name = "{index}. 예외 발생 입력값 = {0}")
        @ValueSource(strings = {"1", "12", "1234"})
        void invalidGameNumberSize(String input) {
            List<Integer> numbers = createNumbers(input);

            assertThrows(IllegalArgumentException.class, () ->
                    new GameNumber(numbers));
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
            List<Integer> numbers = createNumbers("123");

            assertDoesNotThrow(() -> new GameNumber(numbers));
        }

        @DisplayName("숫자가 1~9 범위를 벗어나면 예외가 발생한다.")
        @Test
        void invalidGameNumberRange() {
            List<Integer> numbers = createNumbers("012");

            assertThrows(IllegalArgumentException.class, () -> new GameNumber(numbers));
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
            List<Integer> numbers = createNumbers("123");

            assertDoesNotThrow(() -> new GameNumber(numbers));
        }

        @Order(2)
        @DisplayName("숫자중 중복되는 숫자가 있으면 예외가 발생한다.")
        @Test
        void gameNumberDuplicate() {
            List<Integer> numbers = createNumbers("122");

            assertThrows(IllegalArgumentException.class, () -> new GameNumber(numbers));
        }
    }

    private List<Integer> createNumbers(String numbers) {
        return Arrays.stream(numbers.split(""))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}