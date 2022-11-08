package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallTest {


    @Test
    @DisplayName("0으로 볼 초기화 생성시 카운트는 0")
    void 볼_0으로_생성시_카운트_0() {
        Ball ball = new Ball(0);
        assertThat(ball.getCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("addCount 실행 시 카운트 1 추가")
    void addCount_실행시_카운트_1_추가() {
        Ball ball = new Ball(0);
        ball.addCount();
        assertThat(ball.getCount()).isEqualTo(1);
    }
}
