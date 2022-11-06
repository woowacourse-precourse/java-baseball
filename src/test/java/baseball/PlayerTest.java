package baseball;

import org.junit.jupiter.api.Test;

import static baseball.Player.getPlayer;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {

    // 플레이어 기능 구현을 위한 테스트
    @Test
    public void 플레이어가_입력한_값_숫자인지_테스트() {
        // given
        String userInput = "1b2";
        // when, then
        assertThatThrownBy(() -> {
            getPlayer().checkNumber(userInput);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력 가능합니다.");
    }

    @Test
    public void 플레이어가_입력한_숫자_길이_테스트() {
        // given
        String userInput = "1234";
        // when, then
        assertThatThrownBy(() -> {
            getPlayer().checkLength(userInput);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("3자리 숫자만 입력 가능합니다.");
    }

    @Test
    public void 플레이어가_입력한_값_서로_다른_숫자인지_테스트() {
        // given
        String userInput = "155";
        // when, then
        assertThatThrownBy(() -> {
            getPlayer().checkDuplication(userInput);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("서로 다른 3자리 숫자만 입력이 가능합니다.");
    }
}