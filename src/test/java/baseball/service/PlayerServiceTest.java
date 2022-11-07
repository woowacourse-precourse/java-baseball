package baseball.service;

import baseball.domain.Player;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class PlayerServiceTest {
    PlayerService playerService = new PlayerService();

    @Nested
    @DisplayName("문자열을 리스트로 변환하여 저장")
    class stringToList {
        @Test
        void case1() {
            Player player = new Player();
            player = playerService.inputNumbersToPlayer("123");
            Assertions.assertThat(player.getNumbers()).contains(1, 2, 3);
        }

        @Test
        void case2() {
            Player player = new Player();
            player = playerService.inputNumbersToPlayer("456");
            Assertions.assertThat(player.getNumbers()).contains(4, 5, 6);
        }

        @Test
        void case3() {
            Player player = new Player();
            player = playerService.inputNumbersToPlayer("789");
            Assertions.assertThat(player.getNumbers()).contains(7, 8, 9);
        }
    }
}
