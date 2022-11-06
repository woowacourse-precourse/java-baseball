package baseball;

import baseball.game.EndGame;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class EndGameTest {

    @Test
    void isRestart_1이나_2가_아니면_예외_발생() {
        assertThatThrownBy(() -> EndGame.isRestart(3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Argument length out of range");
    }

    @Test
    void isRestart_1이라면_true_반환() {
        assertThat(EndGame.isRestart(1)).isEqualTo(true);
    }
}
