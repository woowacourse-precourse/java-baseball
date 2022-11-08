package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class JudgeTest {

    private final Judge judge = new Judge();

    @Test
    void ball개수_확인() {
        List<Integer> pitcherNumber = new ArrayList<>(List.of(1, 2, 3));
        List<Integer> HitterNumber = new ArrayList<>(List.of(2, 3, 4));

        int ballCount = judge.countBall(pitcherNumber, HitterNumber);

        assertThat(ballCount).isEqualTo(2);
    }

    @Test
    void Strike개수_확인() {
        List<Integer> pitcherNumber = new ArrayList<>(List.of(1, 2, 3));
        List<Integer> HitterNumber = new ArrayList<>(List.of(1, 2, 4));

        int strikeCount = judge.countStrike(pitcherNumber, HitterNumber);

        assertThat(strikeCount).isEqualTo(2);
    }
}