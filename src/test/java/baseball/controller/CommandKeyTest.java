package baseball.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CommandKeyTest {
    @DisplayName("커맨드 키는 1,2만 작동한다")
    @Test
    void 커맨드_범위_테스트() {
        assertThat(CommandKey.from(1)).isEqualTo(CommandKey.RETRY);
        assertThat(CommandKey.from(2)).isEqualTo(CommandKey.FINISH);
    }

    @DisplayName("커맨드 키 범위 바깥 체크")
    @Test
    void 커맨드_바깥_테스트() {
        assertThrows(IllegalArgumentException.class, () -> CommandKey.from(0));
        assertThrows(IllegalArgumentException.class, () -> CommandKey.from(3));
    }
}
