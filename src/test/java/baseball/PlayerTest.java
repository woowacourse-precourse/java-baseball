package baseball;

import static baseball.utils.ErrorMessages.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 12, 1234})
    void from_메소드의_입력값이_세_자리가_아닌_경우_예외_발생(int number) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> Player.from(number))
                .withMessage(REQUIRE_THREE_DIGIT_NUMBER);
    }

    @ParameterizedTest
    @ValueSource(ints = {120, 103, -10})
    void from_메소드의_입력값이_1에서_9_사이의_숫자로_이루어지지_않은_경우_예외_발생(int number) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> Player.from(number))
                .withMessage(BETWEEN_ONE_AND_NINE);
    }
}
