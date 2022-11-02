package baseball;

import static baseball.utils.ErrorMessages.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerNumberValidatorTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 12, 1234})
    void validate_메서드_사용시_입력값이_세_자리가_아닌_경우_예외_발생(int input) {
        IntInputValidator validator = new PlayerNumberValidator();
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> validator.validate(input))
                .withMessage(REQUIRE_THREE_DIGIT_NUMBER);
    }

    @ParameterizedTest
    @ValueSource(ints = {120, 103, -10})
    void validate_메서드_사용시_각_숫자가_1에서_9_사이의_값이_아닌_경우_예외_발생(int input) {
        IntInputValidator validator = new PlayerNumberValidator();
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> validator.validate(input))
                .withMessage(BETWEEN_ONE_AND_NINE);
    }
}
