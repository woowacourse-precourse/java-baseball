package mytest;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import baseball.Player;

public class PlayerTest {
    Player player = new Player();

    @DisplayName("입력값이 1과 9 사이의 서로 다른 세 자리 수가 아닌 경우 IllegalArgumetException 발생")
    @Test
    void case1() {
        assertThatThrownBy(() -> player.checkValidation("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void case2() {
        assertThatThrownBy(() -> player.checkValidation("12"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void case3() {
        assertThatThrownBy(() -> player.checkValidation("803"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void case4() {
        assertThatThrownBy(() -> player.checkValidation("6a4"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void case5() {
        assertThatThrownBy(() -> player.checkValidation("**2"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
