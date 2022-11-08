package baseball.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import baseball.util.GameExceptionMessage;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

class NumberBallTest {
    private NumberBall makeNumberBall(int number) {
        return new NumberBall(number);
    }

    @Test
    void 숫자_0_공_생성_예외_발생() {
        assertThatThrownBy(() -> makeNumberBall(0)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(GameExceptionMessage.ENTER_NUMBER_FROM_ONE_TO_NINE);
    }

    @Test
    void 숫자_9이상_공_생성_예외_발생() {
        assertThatThrownBy(() -> makeNumberBall(15)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(GameExceptionMessage.ENTER_NUMBER_FROM_ONE_TO_NINE);
    }

    @Test
    void 공_생성_성공() {
        IntStream.range(1, 10).forEach((idx) -> assertDoesNotThrow(() -> makeNumberBall(idx)));
        IntStream.range(1, 10).forEach((idx) -> assertThat(makeNumberBall(idx).getNumber()).isEqualTo(idx));
    }
}