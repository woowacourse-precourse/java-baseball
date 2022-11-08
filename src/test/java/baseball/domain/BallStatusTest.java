package baseball.domain;

import baseball.domain.score.BallScore;
import baseball.domain.score.Nothing;
import baseball.domain.score.StrikeScore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class BallStatusTest {
    @Test
    @DisplayName("Nothing 인지 확인")
    void is_nothing() {
        assertAll(
                () -> assertThat(BallStatus.STRIKE.isNothing()).isFalse(),
                () -> assertThat(BallStatus.BALL.isNothing()).isFalse(),
                () -> assertThat(BallStatus.NOTHING.isNothing()).isTrue()
        );
    }
    
    @Test
    @DisplayName("반환 객체가 올바른지 확인")
    void is_correct_score() {
        assertAll(
                () -> assertThat(BallStatus.STRIKE.score()).isExactlyInstanceOf(StrikeScore.class),
                () -> assertThat(BallStatus.BALL.score()).isExactlyInstanceOf(BallScore.class),
                () -> assertThat(BallStatus.NOTHING.score()).isExactlyInstanceOf(Nothing.class)
        );
    }
}