package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    @Test
    @DisplayName("정답이 서로 다른 3자리 수가 아닌 경우")
    void isValidAnswer() {
        assertThatThrownBy(() -> Player.isValidAnswer("111"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Player.isValidAnswer("1"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(Player.isValidAnswer("123")).isTrue();
    }

    @Test
    @DisplayName("게임 반복 선택이 1이나 2가 아닌 경우")
    void isValidContinueAnswer() {
        assertThatThrownBy(() -> Player.isValidContinueAnswer(""))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Player.isValidContinueAnswer("12"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Player.isValidContinueAnswer("0"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(Player.isValidContinueAnswer("1")).isTrue();
        assertThat(Player.isValidContinueAnswer("2")).isTrue();
    }
}