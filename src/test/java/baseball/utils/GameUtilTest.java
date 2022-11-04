package baseball.utils;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("GameUtil 테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class GameUtilTest {
    @Test
    void 숫자_랜덤_생성() {
        int number = GameUtil.pickNumber(3);
        List<Integer> splitOneDigits = GameUtil.splitNumberToOneDigitNumbers(number);

        assertThat(number).isNotNegative();
        assertThat(splitOneDigits)
                .allMatch(num -> (num >= 1 && num <= 9))
                .doesNotHaveDuplicates()
                .hasSize(3);
    }

    @DisplayName("숫자 체크")
    @Nested
    class is_valid_Number {
        @ParameterizedTest(name = "올바르지 않은 숫자 => {0}")
        @ValueSource(ints = {2, 21, 210, 212, 220, 221, 222})
        void value_of_false(int number) {
            assertThat(GameUtil.isValidNumber(number)).isFalse();
        }

        @ParameterizedTest(name = "올바른 숫자 => {0}")
        @ValueSource(ints = {123})
        void value_of_true(int number) {
            assertThat(GameUtil.isValidNumber(number)).isTrue();
        }

    }

}
