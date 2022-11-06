package baseball;

import baseball.Model.Referee;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RefereeTest {
    private Referee referee = new Referee();

    @Test
    void 스트라이크() {
        Assertions.assertThat(referee.isStrike(
            new ArrayList<>(List.of(1,5,9)), List.of(1,5,9)
        )).isEqualTo(3);
    }

    @Test
    void 볼() {
        Assertions.assertThat(referee.isBall(
            List.of(1,2,3), List.of(2,3,4)
        )).isEqualTo(2);
    }
}
