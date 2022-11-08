package study.player.playerMember;

import baseball.player.playerMember.PlayerNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class PlayerNumberTest {

    @Test
    void 같은_수를_가진_두개의_볼이_같은지_비교() {
        PlayerNumber playerNumber1 = new PlayerNumber(123);
        PlayerNumber playerNumber2 = new PlayerNumber(123);

        boolean equals = playerNumber2.equals(playerNumber1);

        Assertions.assertThat(equals)
                    .isTrue();
    }

    @Test
    void 다른_수를_가진_두개의_볼이_같은지_비교() {
        PlayerNumber playerNumber1 = new PlayerNumber(123);
        PlayerNumber playerNumber2 = new PlayerNumber(456);

        boolean equals = playerNumber2.equals(playerNumber1);

        Assertions.assertThat(equals)
                .isFalse();
    }

}