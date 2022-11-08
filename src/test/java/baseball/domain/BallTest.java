package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BallTest {

    @Test
    void 랜덤숫자_범위_테스트() {
        Ball ball = new Ball();
        int randomNumber = ball.getRandomNumber();
        assertThat(randomNumber)
                // 양수
                .isPositive()
                // 0보다는 크고
                .isGreaterThan(0)
                // 10보다는 작다
                .isLessThan(10);
    }
}