package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BallTest {

    @Test
    @DisplayName("공 생성 시 위치, 숫자 값이 정상적으로 대입되는지 확인한다.")
    void 공_생성_테스트() {
        // given
        int expectedPosition = 1;
        int expectedNumberValue = 9;

        // when
        Ball ball = Ball.of(
                BallPosition.from(expectedPosition),
                BallNumber.from(expectedNumberValue)
        );

        //then
        assertThat(ball.position()).as("공 위치 정상 대입 확인")
                .isEqualTo(expectedPosition);

        assertThat(ball.number()).as("공 숫자 정상 대입 확인")
                .isEqualTo(expectedNumberValue);
    }
}