package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Nested
    class 문자열을_리스트로_저장 {
        @Test
        void case1() {
            Player player = new Player("123");
            Assertions.assertThat(player.getPlayerNumbers()).containsOnly(1, 2, 3);
        }

        @Test
        void case2() {
            Player player = new Player("236");
            Assertions.assertThat(player.getPlayerNumbers()).containsOnly(2, 3, 6);
        }

        @Test
        void case3() {
            Player player = new Player("635");
            Assertions.assertThat(player.getPlayerNumbers()).containsOnly(6, 3, 5);
        }
    }

}
