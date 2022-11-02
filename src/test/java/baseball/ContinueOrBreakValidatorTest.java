package baseball;

import static baseball.utils.ErrorMessages.REQUIRE_ONE_OR_TWO;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ContinueOrBreakValidatorTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 3})
    void validate_메서드의_입력이_1_또는_2가_아닌_경우_예외_발생(int input) {
        IntInputValidator validator = new ContinueOrBreakValidator();
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> validator.validate(input))
                .withMessage(REQUIRE_ONE_OR_TWO);
    }
}
