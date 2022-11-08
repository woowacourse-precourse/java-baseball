package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class HintTest extends NsTest {
    final List<Integer> randomNumber = new ArrayList<>(List.of(3, 6, 9));

    @Test
    void _1볼() {
        List<Integer> playerNumber = new ArrayList<>(List.of(2, 4, 6));
        HintCalculator.calculateHint(randomNumber, playerNumber);
        assertThat(output()).isEqualTo("1볼");
    }

    @Test
    void _2볼() {
        List<Integer> playerNumber = new ArrayList<>(List.of(2, 3, 6));
        HintCalculator.calculateHint(randomNumber, playerNumber);
        assertThat(output()).isEqualTo("2볼");
    }

    @Test
    void _3볼() {
        List<Integer> playerNumber = new ArrayList<>(List.of(9, 3, 6));
        HintCalculator.calculateHint(randomNumber, playerNumber);
        assertThat(output()).isEqualTo("3볼");
    }

    @Test
    void _1스트라이크() {
        List<Integer> playerNumber = new ArrayList<>(List.of(3, 4, 5));
        HintCalculator.calculateHint(randomNumber, playerNumber);
        assertThat(output()).isEqualTo("1스트라이크");
    }

    @Test
    void _2스트라이크() {
        List<Integer> playerNumber = new ArrayList<>(List.of(2, 6, 9));
        HintCalculator.calculateHint(randomNumber, playerNumber);
        assertThat(output()).isEqualTo("2스트라이크");
    }

    @Test
    void _3스트라이크() {
        List<Integer> playerNumber = new ArrayList<>(List.of(3, 6, 9));
        HintCalculator.calculateHint(randomNumber, playerNumber);
        assertThat(output()).isEqualTo("3스트라이크");
    }

    @Test
    void _1볼_1스트라이크() {
        List<Integer> playerNumber = new ArrayList<>(List.of(3, 4, 6));
        HintCalculator.calculateHint(randomNumber, playerNumber);
        assertThat(output()).isEqualTo("1볼 1스트라이크");
    }

    @Test
    void _2볼_1스트라이크() {
        List<Integer> playerNumber = new ArrayList<>(List.of(3, 9, 6));
        HintCalculator.calculateHint(randomNumber, playerNumber);
        assertThat(output()).isEqualTo("2볼 1스트라이크");
    }

    @Test
    void 낫싱() {
        List<Integer> playerNumber = new ArrayList<>(List.of(1, 4, 7));
        HintCalculator.calculateHint(randomNumber, playerNumber);
        assertThat(output()).isEqualTo("낫싱");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
