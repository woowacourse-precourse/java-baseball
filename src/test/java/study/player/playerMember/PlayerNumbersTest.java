package study.player.playerMember;

import baseball.player.playerMember.PlayerNumbers;
import baseball.uitls.Hints;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


class PlayerNumbersTest {

    @Test
    void 쓰리_스트라이크() {
        PlayerNumbers baseNumber = new PlayerNumbers(123);
        PlayerNumbers compareNumber = new PlayerNumbers(123);

        Hints hints = baseNumber.makeHints(compareNumber);

        Assertions.assertThat(hints.getStrike())
                .isEqualTo(3);
    }

    @Test
    void 투_볼() {
        PlayerNumbers baseNumber = new PlayerNumbers(123);
        PlayerNumbers compareNumber = new PlayerNumbers(214);

        Hints hints = baseNumber.makeHints(compareNumber);

        Assertions.assertThat(hints.getBall())
                .isEqualTo(2);
    }

    @Test
    void 낫싱() {
        PlayerNumbers baseNumber = new PlayerNumbers(123);
        PlayerNumbers compareNumber = new PlayerNumbers(456);

        Hints hints = baseNumber.makeHints(compareNumber);

        Assertions.assertThat(hints.getBall())
                .isEqualTo(0);
        Assertions.assertThat(hints.getStrike())
                .isEqualTo(0);
    }
}