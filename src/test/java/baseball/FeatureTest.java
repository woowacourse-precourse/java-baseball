package baseball;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class FeatureTest {

    @Nested
    class getPlayResultTest {
        @Test
        void case1() {
            List<Integer> userNumber = List.of(1, 4, 7);
            List<Integer> Answer = List.of(1, 4, 7);
            boolean result = false;
            GameService gameService = new GameService();
            assertThat(gameService.getPlayResult(userNumber, Answer)).isEqualTo(result);
        }

        @Test
        void case2() {
            List<Integer> userNumber = List.of(5, 8, 2);
            List<Integer> Answer = List.of(1, 4, 7);
            boolean result = true;
            GameService gameService = new GameService();
            assertThat(gameService.getPlayResult(userNumber, Answer)).isEqualTo(result);
        }

        @Test
        void case3() {
            List<Integer> userNumber = List.of(4, 1, 7);
            List<Integer> Answer = List.of(1, 4, 7);
            boolean result = true;
            GameService gameService = new GameService();
            assertThat(gameService.getPlayResult(userNumber, Answer)).isEqualTo(result);
        }
    }
}
