package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class HintTest {

    @Test
    void create() {
        assertAll(
                () -> assertThat(Hint.STRIKE == Hint.STRIKE).isTrue(),
                () -> assertThat(Hint.BALL == Hint.BALL).isTrue()
        );
    }
}
