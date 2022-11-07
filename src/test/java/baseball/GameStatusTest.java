package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameStatusTest {

    @Test
    void 게임재시작_입력_검사_성공테스트1() {
        assertThat(GameRestartStatus.validStatus("1")).isTrue();
    }

    @Test
    void 게임재시작_입력_검사_성공테스트2() {
        assertThat(GameRestartStatus.validStatus("2")).isTrue();
    }

    @Test
    void 게임재시작_입력_검사_실패테스트() {
        assertThatThrownBy(() -> GameRestartStatus.validStatus("3")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 게임재시작_성공_테스트() {
        GameRestartStatus gameRestartStatus = GameRestartStatus.of("1");
        assertThat(gameRestartStatus.isYes()).isTrue();
    }

    @Test
    void 게임재시작_실패_테스트() {
        GameRestartStatus gameRestartStatus = GameRestartStatus.of("2");
        assertThat(gameRestartStatus.isYes()).isFalse();
    }
}