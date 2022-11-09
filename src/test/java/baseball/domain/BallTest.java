package baseball.domain;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Tag("Unit")
class BallTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 20})
    void 단일_숫자_범위_예외_테스트(int number) {
        assertThatThrownBy(() -> Ball.fromNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}