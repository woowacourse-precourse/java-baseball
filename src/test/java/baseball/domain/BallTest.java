package baseball.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BallTest {
    @DisplayName("예외처리 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0,10})
    public void rangeTest() {
        assertThatThrownBy(() -> {
            new Ball(0);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
