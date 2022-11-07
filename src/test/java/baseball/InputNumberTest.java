package baseball;

import baseball.controller.GameController;
import baseball.model.Player;
import baseball.validator.PlayerInputValidator;
import baseball.view.SystemMessage;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputNumberTest {

    GameController gameController = new GameController();
    PlayerInputValidator playerInputValidator = new PlayerInputValidator();

    @Test
    void 플레이어에_저장된_숫자가_3개인지_확인() {
        Player player = new Player();
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        player.setPlayerNumbers(numbers);
        assertThat(player.getNumbers().size()).isEqualTo(3);
    }

    @Test
    void 플레이어가_숫자만을_입력했는지_확인() {
        String input = "123";
        List<Integer> output = Arrays.asList(1, 2, 3);
        assertThat(playerInputValidator.getDigitList(input)).isEqualTo(output);
    }

    @Test
    void 플레이어가_숫자가_아닌_문자를_입력한다면_예외처리() {
        String input = "abc";
        assertThatThrownBy(() -> playerInputValidator.getDigitList(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(SystemMessage.INPUT_IS_NOT_A_NUMBER.getMessage());
    }

    @Test
    void 플레이어의_입력값의_길이가_3인지_확인() {
        String input = "123";
        int inputSize = playerInputValidator.getDigitList(input).size();
        assertThat(inputSize).isEqualTo(3);
    }

    @Test
    void 플레이어의_입력값의_길이가_3이_아니면_예외처리() {
        String input = "1234";
        assertThatThrownBy(() -> playerInputValidator.getDigitList(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(SystemMessage.INPUT_LENGTH_IS_NOT_THREE.getMessage());
    }

    @Test
    void 플레이어의_입력값에_중복이_있으면_예외처리() {
        String input = "121";
        assertThatThrownBy(() -> playerInputValidator.getDigitList(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(SystemMessage.INPUT_NUMBER_IS_NOT_UNIQUE.getMessage());
    }
}
