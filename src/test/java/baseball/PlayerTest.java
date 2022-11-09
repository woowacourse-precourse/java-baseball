package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

public class PlayerTest {
    @Nested
    class TestIsValidBaseballNumber {
        Player player = new Player();

        @Test
        @DisplayName("사용자의 입력에 대한 예외처리 테스트")
        void case1() {
            String playerInput = "315";
            List<Integer> result = List.of(3, 1, 5);
            player.isValidBaseballNumber(playerInput);
            assertThat(player.getBaseballNumber()).isEqualTo(result);
        }

        @Test
        @DisplayName("3개 이상의 수를 입력한 경우 ")
        void case2() {
            String playerInput = "31895";
            assertThatThrownBy(() -> player.isValidBaseballNumber(playerInput))
                    .isInstanceOf(IllegalArgumentException.class);
        }


        @Test
        @DisplayName("3개 이하의 수를 입력한 경우 ")
        void case3() {
            String playerInput = "35";
            assertThatThrownBy(() -> player.isValidBaseballNumber(playerInput))
                    .isInstanceOf(IllegalArgumentException.class);

        }

        @Test
        @DisplayName("숫자가 아닌 문자를 입력한 경우")
        void case4() {
            String playerInput = "숫자말고문자";
            assertThatThrownBy(() -> player.isValidBaseballNumber(playerInput))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("중복된 숫자를 입력한 경우")
        void case5() {
            String playerInput = "114";
            assertThatThrownBy(() -> player.isValidBaseballNumber(playerInput))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("0이 포함된 경우")
        void case6() {
            String playerInput = "104";
            assertThatThrownBy(() -> player.isValidBaseballNumber(playerInput))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
