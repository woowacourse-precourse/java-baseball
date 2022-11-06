package mytest;

import static org.assertj.core.api.Assertions.*;

import baseball.settings.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidatorTest {
    @Nested
    @DisplayName("입력값이 유효하지 않을 때 예외가 발생하는지 확인")
    class InvalidNumberTest {
        @DisplayName("IllegalArgumentException 테스트")
        @ParameterizedTest
        @ValueSource(strings = {"1234", "1!3", "12", "", "a72", "803", "886", "919", "141", "332", "277"})
        void illegalArgumentExceptionTest(String input) {
            assertThatThrownBy(() -> Validator.check(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("1과 9 사이의 세 자리 수 테스트")
        @ParameterizedTest
        @ValueSource(strings = {"1234", "1!3", "12", "", "a72", "803"})
        void threeNumbersTest(String input) {
            boolean result = Validator.hasThreeDigits(input);
            assertThat(result).isFalse();
        }

        @DisplayName("중복 여부 테스트")
        @ParameterizedTest
        @ValueSource(strings = {"886", "919", "141", "332", "277"})
        void uniquenessTest(String input) {
            boolean result = Validator.hasDifferentDigits(input);
            assertThat(result).isFalse();
        }
    }

    @Nested
    @DisplayName("입력값이 유효할 때 통과하는지 확인")
    class ValidNumberTest {
        @DisplayName("No exception 테스트")
        @ParameterizedTest
        @ValueSource(strings = {"123", "654", "493", "761", "587", "213", "874", "527"})
        void noExceptionTest(String input) {
            Throwable throwable = catchThrowable(() -> Validator.check(input));
            assertThat(throwable).isNull();
        }

        @DisplayName("1과 9 사이의 세 자리 수 테스트")
        @ParameterizedTest
        @ValueSource(strings = {"123", "654", "493", "761", "587", "213", "874", "527"})
        void threeNumbersTest(String input) {
            boolean result = Validator.hasThreeDigits(input);
            assertThat(result).isTrue();
        }

        @DisplayName("중복 여부 테스트")
        @ParameterizedTest
        @ValueSource(strings = {"123", "654", "493", "761", "587", "213", "874", "527"})
        void uniquenessTest(String input) {
            boolean result = Validator.hasThreeDigits(input);
            assertThat(result).isTrue();
        }
    }
}
