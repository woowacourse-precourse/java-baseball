package baseball.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import baseball.util.GameExceptionMessage;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberBallTest {
    private NumberBall makeNumberBall(int number) {
        return new NumberBall(number);
    }

    @Test
    @DisplayName("0으로 공 생성 예외 발생")
    void case1() {
        assertThatThrownBy(() -> makeNumberBall(0)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(GameExceptionMessage.USER_NUMBER_RANGE);
    }

    @Test
    @DisplayName("9이상 숫자로 공 생성 예외 발생")
    void case2() {
        assertThatThrownBy(() -> makeNumberBall(15)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(GameExceptionMessage.USER_NUMBER_RANGE);
    }

    @Test
    @DisplayName("공 생성 성공")
    void case3() {
        IntStream.range(1, 10).forEach((idx) -> assertDoesNotThrow(() -> makeNumberBall(idx)));
        IntStream.range(1, 10).forEach((idx) -> assertThat(makeNumberBall(idx).getNumber()).isEqualTo(idx));
    }
}