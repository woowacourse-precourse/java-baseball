package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BallNumberTest {

    private static final String OUT_OF_RANGE_ERR_MESSAGE
        = "야구 숫자는 1~9까지만 가능합니다.";

    @DisplayName("Ball 매개변수의 범위 검증")
    @ParameterizedTest
    @ValueSource(ints = {0, 10, -1})
    void ball_매개변수_범위_검증(int number) {
        assertThatThrownBy(
            () -> new BallNumber(number)
        ).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(OUT_OF_RANGE_ERR_MESSAGE);
    }
}
