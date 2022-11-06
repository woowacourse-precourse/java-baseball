package baseball.player;

import baseball.utils.appConfig.AppConfig;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerInputTest {

    PlayerInput playerInput = AppConfig.createPlayerInput();

    @Test
    void 사용자_정상_입력시_리스트_형태로_저장() {
        playerInput.setNumbers("123");
        String numbers = playerInput.getNumbers().toString();

        assertThat(numbers).isEqualTo("[1, 2, 3]");
    }


    @Test
    void 사용자_입력이_서로_다른_수로_이루어지지_않은_경우_예외() {
        assertThatThrownBy(() -> playerInput.setNumbers("122"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사용자_입력이_1부터_9사이의_숫자로_이루어지지_않은_경우_예외() {
        assertThatThrownBy(() -> playerInput.setNumbers("109"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사용자_입력이_숫자로_이루어지지_않은_경우_예외() {
        assertThatThrownBy(() -> playerInput.setNumbers("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사용자_3자리_이상_입력시_예외() {
        assertThatThrownBy(() -> playerInput.setNumbers("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}