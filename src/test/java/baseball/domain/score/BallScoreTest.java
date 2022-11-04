package baseball.domain.score;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallScoreTest {
    private Score score;
    
    @BeforeEach
    void setUp() {
        score = new BallScore();
    }
    
    @Test
    @DisplayName("예외 처리 : BALL 개수가 종료 조건에 영향을 미칠 경우")
    void is_end() {
        assertThatThrownBy(score::isGameEnd)
                .isInstanceOf(UnsupportedOperationException.class)
                .hasMessage("BALL 의 개수는 게임 종료의 조건이 되지 않습니다.");
    }
    
    @Test
    @DisplayName("스코어 증가")
    void increase() {
        score = score.increase();
        assertThat(score.score()).isEqualTo(1);
    }
}