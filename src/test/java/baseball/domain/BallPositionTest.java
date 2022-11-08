package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

class BallPositionTest {
    @DisplayName("올바른 볼 위치인지 확인")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(ints = {0, 1, 2})
    void correct_ball_position(int ballPosition) {
        assertThatNoException()
                .isThrownBy(() -> new BallPosition(ballPosition));
    }
    
    @DisplayName("예외 처리 : 0~2 범위를 벗어난 경우")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(ints = {-1, 3})
    void out_of_position_range(int position) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BallPosition(position))
                .withMessage("Position 은 0~2 사이여야 합니다.");
    }
}