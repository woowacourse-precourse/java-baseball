package baseball.domain.number;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class BaseballNumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "10", "11", "12", "13", "000"})
    void 야구게임_넘버는_1과_9사이의_숫자로_이루어집니다(final Integer input) {
        assertThatThrownBy(() -> {
            var number = new BaseballNumber(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BaseballNumber.ERROR_NUMBER_SIZE);
    }

    @Test
    void 야구게임_숫자는_값이_같으면_서로_같은_숫자입니다() {
        for (int i = 1; i <= 9; i++) {
            var number1 = new BaseballNumber(i);
            var number2 = new BaseballNumber(i);
            assertThat(number1).isEqualTo(number2);
        }
    }

    @Test
    void 야구게임_숫자는_값이_다르면_디른_숫자입니다() {
        for (int i = 1; i <= 9; i++) {
            if (i == 5) {
                break;
            }
            var number1 = new BaseballNumber(i);
            var number2 = new BaseballNumber(10 - i);

            assertThat(number1).isNotEqualTo(number2);
        }
    }

}
