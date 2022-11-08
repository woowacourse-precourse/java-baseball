package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class JudgeTest {

    private final Judge judge = new Judge();

    @Test
    void ball개수_확인() {
        Set<Integer> pitcherNumber = new HashSet<>(Set.of(1, 2, 3));
        Set<Integer> HitterNumber = new HashSet<>(Set.of(2, 3, 4));

        int ballCount = judge.countBall(pitcherNumber, HitterNumber);

        assertThat(ballCount).isEqualTo(2);
    }
}