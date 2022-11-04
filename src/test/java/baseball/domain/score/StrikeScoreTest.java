package baseball.domain.score;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StrikeScoreTest {
    @Test
    @DisplayName("3스트라이크 => 게임 종료인지 확인")
    void is_end() {
        Score score = new StrikeScore(3);
        
        assertThat(score.isGameEnd()).isTrue();
    }
    
    @Test
    @DisplayName("스코어 증가")
    void increase() {
        Score score = new StrikeScore(2);
        score = score.increase();
        
        assertThat(score.score()).isEqualTo(3);
    }
}