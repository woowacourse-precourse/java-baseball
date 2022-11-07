package baseball.domain.player;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class UserPlayerTest {

    Player userPlayer = new UserPlayer();

    @Test
    public void 입력받은_값이_3자리_수인지_확인하고_아니면_예외_발생() {
        assertThatThrownBy(() -> userPlayer.checkLengthOfInput("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}