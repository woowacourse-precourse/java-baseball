package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {
    @Test
    @DisplayName("3스트라이크 => 게임 종료되었는지 확인")
    void is_end() {
        Referee referee = new Referee();
        referee.decide(List.of(BallStatus.STRIKE, BallStatus.STRIKE, BallStatus.STRIKE));
        
        assertThat(referee.isEnd()).isTrue();
    }
}