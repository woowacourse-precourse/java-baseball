package study.player.playerMember;

import baseball.player.playerMember.PlayerNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


class PlayerNumbersTest {

    @Test
    void 쓰리_스트라이크() {
        PlayerNumbers baseNumber = new PlayerNumbers(123);
        PlayerNumbers compareNumber = new PlayerNumbers(123);

        List<Integer> hints = baseNumber.makeHints(compareNumber);

        Assertions.assertThat(hints)
                    .containsExactly(0, 3);
    }

    @Test
    void 투_볼() {
        PlayerNumbers baseNumber = new PlayerNumbers(123);
        PlayerNumbers compareNumber = new PlayerNumbers(214);

        List<Integer> hints = baseNumber.makeHints(compareNumber);

        Assertions.assertThat(hints)
                    .containsExactly(2, 0);
    }

    @Test
    void 낫싱() {
        PlayerNumbers baseNumber = new PlayerNumbers(123);
        PlayerNumbers compareNumber = new PlayerNumbers(456);

        List<Integer> hints = baseNumber.makeHints(compareNumber);

        Assertions.assertThat(hints)
                .containsExactly(0, 0);
    }
}