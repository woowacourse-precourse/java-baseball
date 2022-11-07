package baseball.valid;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerInputNumberValidatorTest {

    private static final int NUMBER_LENGTH = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private final static String invalidLengthMessage = "길이가 " +  NUMBER_LENGTH + "이어야 합니다.";
    private final static String duplicateMessage = "엽력값이 중복되지 않아야 합니다.";
    private final static String numberRangeMessage = MIN_NUMBER + "에서 " + MAX_NUMBER +"사이 범위의 숫자가 입력되어야 합니다.";

    @Test
    void validateLength_입력값_길이_검증() {
        assertThatThrownBy(() -> PlayerInputNumberValidator.validateLength("1234"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(invalidLengthMessage);
    }

    @Test
    void validateDuplicate_입력값_중복_검증() {
        assertThatThrownBy(() -> PlayerInputNumberValidator.validateDuplicate("111"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(duplicateMessage);
    }

    @Test
    void validateNumberRange_입력값_숫자범위_검증() {
        assertThatThrownBy(() -> PlayerInputNumberValidator.validateNumberRange("AAA"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(numberRangeMessage);
    }
}