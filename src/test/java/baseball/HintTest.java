package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class HintTest {

    @Test
    void 힌트_메시지() {
        Hint hint = new Hint();

        List<Integer> player = Arrays.asList(1, 2, 3);
        List<Integer> computer = Arrays.asList(3, 2, 1);
        assertThat(assertThat(hint.getBaseballResult(player, computer)).isEqualTo("2볼 1스트라이크"));

        player = Arrays.asList(6, 2, 7);
        computer = Arrays.asList(7, 2, 5);
        assertThat(assertThat(hint.getBaseballResult(player, computer)).isEqualTo("1볼 1스트라이크"));

        player = Arrays.asList(7, 2, 5);
        computer = Arrays.asList(7, 2, 5);
        assertThat(assertThat(hint.getBaseballResult(player, computer)).isEqualTo("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료"));

        player = Arrays.asList(6, 3, 7);
        computer = Arrays.asList(6, 3, 1);
        assertThat(assertThat(hint.getBaseballResult(player, computer)).isEqualTo("2스트라이크"));

        player = Arrays.asList(6, 9, 1);
        computer = Arrays.asList(6, 3, 4);
        assertThat(assertThat(hint.getBaseballResult(player, computer)).isEqualTo("1스트라이크"));

        player = Arrays.asList(9, 3, 7);
        computer = Arrays.asList(6, 2, 1);
        assertThat(assertThat(hint.getBaseballResult(player, computer)).isEqualTo("낫싱"));

        player = Arrays.asList(4, 9, 3);
        computer = Arrays.asList(9, 3, 4);
        assertThat(assertThat(hint.getBaseballResult(player, computer)).isEqualTo("3볼"));

        player = Arrays.asList(1, 8, 3);
        computer = Arrays.asList(8, 7, 1);
        assertThat(assertThat(hint.getBaseballResult(player, computer)).isEqualTo("2볼"));

        player = Arrays.asList(6, 9, 2);
        computer = Arrays.asList(9, 3, 4);
        assertThat(assertThat(hint.getBaseballResult(player, computer)).isEqualTo("1볼"));
    }
}
