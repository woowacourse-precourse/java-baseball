package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class MatchTest {

    @Test
    void strike_test_1() {
        List<Integer> defenceNumber = List.of(1, 3, 4);
        List<Integer> offenceNumber = List.of(2, 3, 4);

        BaseballGame baseballGame = new BaseballGame();

        assertThat(baseballGame.checkStrike(defenceNumber, offenceNumber)).isEqualTo(2);
    }

    @Test
    void strike_test_2() {
        List<Integer> defenceNumber = List.of(1, 3, 4);
        List<Integer> offenceNumber = List.of(3, 4, 1);

        BaseballGame baseballGame = new BaseballGame();

        assertThat(baseballGame.checkStrike(defenceNumber, offenceNumber)).isEqualTo(0);
    }

    @Test
    void strike_test_3() {
        List<Integer> defenceNumber = List.of(1, 3, 4);
        List<Integer> offenceNumber = List.of(1, 9, 8);

        BaseballGame baseballGame = new BaseballGame();

        assertThat(baseballGame.checkStrike(defenceNumber, offenceNumber)).isEqualTo(1);
    }

    @Test
    void strike_test_4() {
        List<Integer> defenceNumber = List.of(7, 5, 1);
        List<Integer> offenceNumber = List.of(7, 5, 1);

        BaseballGame baseballGame = new BaseballGame();

        assertThat(baseballGame.checkStrike(defenceNumber, offenceNumber)).isEqualTo(3);
    }
}
