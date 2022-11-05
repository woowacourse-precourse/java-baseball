package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballGameTest {
    BaseballGame baseballGame = new BaseballGame();
    @Test
    void computerNumber() {
        assertThat(baseballGame.createComputerNumber()).isNotEmpty();
        assertThat(baseballGame.createComputerNumber()).doesNotContain(0);
    }
}
