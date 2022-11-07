package baseball.numbers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class NumberTest {
    @ValueSource(ints = {1, 9})
    @ParameterizedTest
    void 입력을_받아_Number를_반환한다(int input) {
        assertDoesNotThrow(() -> Number.from(input));
    }

    @ValueSource(ints = {-1, 0, 10})
    @ParameterizedTest
    void 입력의_범위가_1이상_9이하가_아니면_예외를_반환한다(int input) {
        assertThatThrownBy(() -> Number.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ValueSource(strings = {"1", "9"})
    @ParameterizedTest
    void 입력을_받아_Number를_반환한다(String input) {
        assertDoesNotThrow(() -> Number.from(input));
    }

    @ValueSource(strings = {"-1", "0", "10"})
    @ParameterizedTest
    void 입력의_범위가_1이상_9이하가_아니면_예외를_반환한다(String input) {
        assertThatThrownBy(() -> Number.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ValueSource(ints = {1, 9})
    @ParameterizedTest
    void 같은_숫자로_생성된_Number는_동일하다(int input) {
        Number first = Number.from(input);
        Number second = Number.from(input);
        assertThat(first).isSameAs(second);
    }

    @ValueSource(ints = {1, 9})
    @ParameterizedTest
    void 같은_숫자로_생성된_Number는_동등하다(int input) {
        Number first = Number.from(input);
        Number second = Number.from(input);
        assertThat(first).isEqualTo(second);
    }
}
