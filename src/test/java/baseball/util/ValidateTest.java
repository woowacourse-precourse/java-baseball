package baseball.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ValidateTest {

    @DisplayName("3자리인지 확인하는 기능")
    @Test
    void isRuleDigit_success() {
        String input = "abc";

        assertThat(input.length()).isEqualTo(GameRule.NUMBER_OF_NUMBERS);
        assertThat(Validate.isRuleDigit(input)).isTrue();
    }

    @DisplayName("3자리가 아닌것을 확인하는 기능")
    @Test
    void isRuleDigit_fail() {
        String input = "abcdef";

        assertThat(input.length()).isNotEqualTo(GameRule.NUMBER_OF_NUMBERS);
        assertThat(Validate.isRuleDigit(input)).isFalse();
    }

}