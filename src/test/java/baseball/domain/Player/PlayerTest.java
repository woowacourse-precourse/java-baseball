package baseball.domain.Player;

import static baseball.StringEnum.InputExceptionCode.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {
    private Player player;

    @BeforeEach
    void createPlayer() {
        player = new Player();
    }

    @Test
    @DisplayName("사용자_입력_난수에_이상이_없는_케이스를_테스트한다")
    void 사용자_입력_숫자_리스트_생성_성공() {
        String inputString = "123";
        List<Integer> result = List.of(1, 2, 3);

        player.readBallNumberInput(inputString);

        assertThat(player.getBallNumbers()).isEqualTo(result);
    }

    @Test
    @DisplayName("사용자_입력_난수에_숫자_외의_문자가_포함되는_케이스를_테스트한다")
    void 사용자_입력_숫자_문자_포함_예외() {
        String inputString = "12/3";

        assertThatThrownBy(() -> player.readBallNumberInput(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_NUMBER_INCLUDE.getCode());
    }

    @Test
    @DisplayName("사용자_입력_난수가_3개가_아닌_경우를_테스트한다")
    void 사용자_입력_숫자_개수_예외() {
        String inputString = "1234";

        assertThatThrownBy(() -> player.readBallNumberInput(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_3_NUMBERS.getCode());
    }

    @Test
    @DisplayName("사용자_입력_난수가_범위를_벗어난_경우를_테스트한다")
    void 사용자_입력_숫자_범위_예외() {
        String inputString = "104";

        assertThatThrownBy(() -> player.readBallNumberInput(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_IN_RANGE.getCode());
    }

    @Test
    @DisplayName("사용자_입력_난수에_중복이_있는_경우를_테스트한다")
    void 사용자_입력_숫자_중복_예외() {
        String inputString = "414";

        assertThatThrownBy(() -> player.readBallNumberInput(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_NUMBER.getCode());
    }
}
