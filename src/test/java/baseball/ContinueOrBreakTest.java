package baseball;

import static baseball.utils.ErrorMessages.REQUIRE_ONE_OR_TWO;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ContinueOrBreakTest {
    @DisplayName("from_메소드의_입력값이_1_또는_2가_아닌_경우_예외_발생")
    @Nested
    class FromTest {
        @ParameterizedTest(name = "입력값={0}")
        @ValueSource(ints = {-1, 0, 3})
        void from_메소드의_입력값이_1_또는_2가_아닌_경우_예외_발생(int code) {
            Assertions.assertThatIllegalArgumentException()
                    .isThrownBy(() -> ContinueOrBreak.from(code))
                    .withMessage(REQUIRE_ONE_OR_TWO);
        }
    }
}
