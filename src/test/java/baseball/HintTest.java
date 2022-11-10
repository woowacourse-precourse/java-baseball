package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class HintTest {

    @Test
    void 올바른_힌트_출력() {
        Hint hint = new Hint(List.of(1, 2, 3), List.of(1, 2, 5), 3);
        assertThat(hint.getStrike()).isEqualTo(2);
        assertThat(hint.getBall()).isEqualTo(0);
    }
}