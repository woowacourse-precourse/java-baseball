package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BallStatusScoreTest {
    @Test
    @DisplayName("3스트라이크 => 게임 종료인지 확인")
    void is_end() {
        BallStatusScore ballStatusScore = new BallStatusScore(3);
        
        assertThat(ballStatusScore.isGameEnd()).isTrue();
    }
}