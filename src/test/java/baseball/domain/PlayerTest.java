package baseball.domain;

import baseball.util.Number;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {
    private Player player;

    @BeforeEach
    protected final void init() {
        player = new Player();
    }

    @Nested
    class InputValidationTest {
        @Test
        void checkInput_메서드_사용시_입력된_문자열_길이가_길거나_짧을_때_예외_발생() {
            assertThatThrownBy(() -> player.checkInput("1234"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(Number.PRESCRIBED_DIGITS + "자리 숫자");

            assertThatThrownBy(() -> player.checkInput("12"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(Number.PRESCRIBED_DIGITS + "자리 숫자");
        }

        @Test
        void checkInput_메서드_사용시_문자를_입력했을_때_예외_발생() {
            assertThatThrownBy(() -> player.checkInput("1_3"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("문자가 아닌 숫자");

            assertThatThrownBy(() -> player.checkInput(" 12"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("문자가 아닌 숫자");
        }

        @Test
        void checkInput_메서드_사용시_0을_입력했을_때_예외_발생() {
            assertThatThrownBy(() -> player.checkInput("120"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("1부터 9사이의 숫자");
        }

        @Test
        void checkInput_메서드_사용시_중복된_숫자를_입력했을_때_예외_발생() {
            assertThatThrownBy(() -> player.checkInput("111"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("서로 다른 숫자");

            assertThatThrownBy(() -> player.checkInput("212"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("서로 다른 숫자");
        }
    }
}
