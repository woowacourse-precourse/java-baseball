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
    @DisplayName("사용자 입력 난수에 이상이 없는 케이스를 테스트한다")
    void 사용자_입력_숫자_리스트_생성_성공() {
        String inputString = "123";
        List<Integer> result = List.of(1, 2, 3);

        player.readBallNumberInput(inputString);

        assertThat(player.getBallNumbers()).isEqualTo(result);
    }

    @Test
    @DisplayName("사용자 입력 난수에 숫자 외의 문자가 포함되는 케이스를 테스트한다")
    void 사용자_입력_숫자_문자_포함_예외() {
        String inputString = "12/3";

        assertThatThrownBy(() -> player.readBallNumberInput(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_NUMBER_INCLUDE.toString());
    }

    @Test
    @DisplayName("사용자 입력 난수가 3개가 아닌 경우를 테스트한다")
    void 사용자_입력_숫자_개수_예외() {
        String inputString = "1234";

        assertThatThrownBy(() -> player.readBallNumberInput(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_3_NUMBERS.toString());
    }

    @Test
    @DisplayName("사용자 입력 난수가 범위를 벗어난 경우를 테스트한다")
    void 사용자_입력_숫자_범위_예외() {
        String inputString = "104";

        assertThatThrownBy(() -> player.readBallNumberInput(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_IN_RANGE.toString());
    }

    @Test
    @DisplayName("사용자 입력 난수에 중복이 있는 경우를 테스트한다")
    void 사용자_입력_숫자_중복_예외() {
        String inputString = "414";

        assertThatThrownBy(() -> player.readBallNumberInput(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_NUMBER.toString());
    }
}
