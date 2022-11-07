package baseball.game;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DecisionTest {
    @CsvSource(value = {"1:RE_GAME", "2:END"}, delimiter = ':')
    @ParameterizedTest
    void 입력을_바탕으로_결정을_반환한다(String input, Decision decision) {
        assertThat(Decision.from(input)).isEqualTo(decision);
    }

    @ValueSource(strings = {"0", "3", "a", "!", "#", "123"})
    @ParameterizedTest
    void 존재하지_않는_결정을_입력하는_경우_예외가_발생한다(String input) {
        assertThatThrownBy(() -> Decision.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
