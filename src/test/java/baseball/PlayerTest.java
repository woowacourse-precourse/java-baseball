package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {


    @Nested
    @DisplayName("사용자의 입력 테스트")
    class PlayerInputTest {

        @Test
        @DisplayName("입력값에 문자가 포함된 경우 예외처리")
        void PlayerInputTest1() {
            Player player = new Player();

            assertThatThrownBy(() -> player.input("a23"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("입력값은 숫자만 포함되어야 합니다.");

        }

        @Test
        @DisplayName("입력값에 0이 포함된 경우 예외처리")
        void PlayerInputTest2() {
            Player player = new Player();

            assertThatThrownBy(() -> player.input("012"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("입력값에 0이 포함될 수 없습니다.");

        }


        @Test
        @DisplayName("입력값이 세자리가 아닌 경우 예외처리")
        void PlayerInputTest3() {
            Player player = new Player();

            assertThatThrownBy(() -> player.input("0123"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("입력값은 세자리여야 합니다.");
        }


        @Test
        @DisplayName("입력값에 수의 중복이 존재하는 경우 예외처리")
        void PlayerInputTest4() {
            Player player = new Player();

            assertThatThrownBy(() -> player.input("113"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("입력값에 수의 중복이 존재합니다.");
        }
    }
}
