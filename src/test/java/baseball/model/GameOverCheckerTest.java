package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class GameOverCheckerTest {

    @Test
    void check() {
        assertThat(GameOverChecker.check(List.of(3, 0, 0))).isTrue();
        assertThat(GameOverChecker.check(List.of(2, 1, 0))).isFalse();
    }
}
