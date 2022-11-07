package baseball.service;

import baseball.domain.Player;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PlayerServiceTest {
    PlayerService playerService = new PlayerService();

    @Nested
    @DisplayName("문자열을 리스트로 변환하여 저장")
    class stringToList {
        @Test
        @DisplayName("123")
        void case1() {
            playerService.inputNumbersToPlayer("123");
            Player player = playerService.getPlayer();
            Assertions.assertThat(player.getNumbers()).contains(1, 2, 3);
        }

        @Test
        @DisplayName("456")
        void case2() {
            playerService.inputNumbersToPlayer("456");
            Player player = playerService.getPlayer();
            Assertions.assertThat(player.getNumbers()).contains(4, 5, 6);
        }

        @Test
        @DisplayName("789")
        void case3() {
            playerService.inputNumbersToPlayer("789");
            Player player = playerService.getPlayer();
            Assertions.assertThat(player.getNumbers()).contains(7, 8, 9);
        }
    }

    @Nested
    @DisplayName("예외 테스트")
    class exceptionTest {
        @ParameterizedTest
        @CsvSource({
                "12", "112", "1a3", "1 3", "1-3"
        })
        @DisplayName("예외 발생 O")
        void case1(String inputNumbers) {
            Assertions.assertThatThrownBy(() -> playerService.inputNumbersToPlayer(inputNumbers))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @CsvSource({
                "123", "456", "789", "156", "742", "325", "634", "531"
        })
        @DisplayName("예외 발생 X")
        void case2(String inputNumbers) {
            Assertions.assertThatCode(() -> playerService.inputNumbersToPlayer(inputNumbers))
                    .doesNotThrowAnyException();
        }
    }
}
