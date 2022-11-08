package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JudgeTest {

    private final Judge judge = new Judge();

    List<Integer> pitcherNumber;
    List<Integer> hitterNumber;

    @BeforeEach
    void setNumber() {
        pitcherNumber = new ArrayList<>(List.of(1, 2, 3));
        hitterNumber = new ArrayList<>(List.of(1, 2, 4));
    }

    @Test
    void Ball개수_확인() {
        int ballCount = judge.countBall(hitterNumber, pitcherNumber);

        assertThat(ballCount).isEqualTo(0);
    }

    @Test
    void Strike개수_확인() {
        int strikeCount = judge.countStrike(hitterNumber, pitcherNumber);

        assertThat(strikeCount).isEqualTo(2);
    }

    @Test
    void Nothing여부_확인() {
        boolean nothing = judge.isNoting(hitterNumber, pitcherNumber);

        assertThat(nothing).isFalse();
    }
}