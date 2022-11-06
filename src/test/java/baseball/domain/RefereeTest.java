package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {
    private Referee referee;
    
    @BeforeEach
    void setUp() {
        referee = new Referee();
    }
    
    @Test
    @DisplayName("3스트라이크 => 게임 종료되었는지 확인")
    void is_end() {
        referee.decide(List.of(BallStatus.STRIKE, BallStatus.STRIKE, BallStatus.STRIKE));
        
        assertThat(referee.isBaseBallGameEnd()).isTrue();
    }
    
    @Test
    @DisplayName("스트라이크와 볼의 점수 구하기")
    void calculate_result() {
        referee.decide(List.of(BallStatus.STRIKE, BallStatus.BALL, BallStatus.STRIKE));
        final List<Integer> scores = referee.scores();
        
        assertThat(scores).isEqualTo(List.of(1, 2));
    }
}