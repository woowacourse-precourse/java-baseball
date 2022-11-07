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

    @Test
    public void 입력받은_값의_각_자리_수가_서로_다른지_확인하고_아니면_예외_발생() {
        int[] arrInput = {1, 2, 2};
        assertThatThrownBy(() -> userPlayer.checkDuplicationOfInput(arrInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

}