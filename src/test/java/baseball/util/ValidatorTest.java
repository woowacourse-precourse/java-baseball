package baseball.util;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

    @Nested
    class invalidInput {

        @DisplayName("입력 범위 초과")
        @ParameterizedTest
        @ValueSource(strings = {"222222222222222222", "12731267764214627128721763"})
        void int_범위를_초과한_입력(String input) {
            assertThatThrownBy(() -> Validator.getValidatedPlayerNumber(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.NOT_NUMERIC.getMessage());
        }

        @ParameterizedTest
        @ValueSource(strings = {"102", "000", "120"})
        void 범위를_초과한_숫자_입력(String input) {
            assertThatThrownBy(() -> Validator.getValidatedPlayerNumber(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.NOT_IN_RANGE.getMessage());
        }

        @ParameterizedTest
        @ValueSource(strings = {"123124", "12", "2134"})
        void 세자리가_아닌_숫자_입력(String input) {
            assertThatThrownBy(() -> Validator.getValidatedPlayerNumber(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INVALID_LENGTH.getMessage());
        }
    }

}