package baseball;

import static baseball.utils.ErrorMessages.REQUIRE_ONE_OR_TWO;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ContinueOrBreakTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 3})
    void from_메소드의_입력값이_1_또는_2가_아닌_경우_예외_발생(int code) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> ContinueOrBreak.from(code))
                .withMessage(REQUIRE_ONE_OR_TWO);
    }
}
