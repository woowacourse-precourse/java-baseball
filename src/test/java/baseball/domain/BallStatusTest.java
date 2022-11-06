package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
}