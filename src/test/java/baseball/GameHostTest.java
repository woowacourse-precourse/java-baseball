package baseball;

import org.junit.jupiter.api.*;
import utils.InputUtils;
import java.util.List;
import static org.assertj.core.api.Assertions.*;


public class GameHostTest {
    @Nested
    class TestIsValidBaseballNumber {
        GameHost gameHost = new GameHost();
        @Test
        @DisplayName("난수가 세 자리인지 확인")
        void case1() {
            gameHost.setBaseballNumber();
            List<Integer> baseballNumber = gameHost.getBaseballNumber();
            boolean result = InputUtils.isBaseballNumberLength3(baseballNumber);
            assertThat(result).isTrue();
        }

        @Test
        @DisplayName("난수의 각 자리가 1~9 범위 사이에 있는지 확인")
        void case2() {
            gameHost.setBaseballNumber();
            List<Integer> baseballNumber = gameHost.getBaseballNumber();
            boolean result = InputUtils.isValidRange(baseballNumber);
            assertThat(result).isTrue();
        }

        @Test
        @DisplayName("난수에 중복되는 수가 있는지 확인")
        void case3() {
            gameHost.setBaseballNumber();
            List<Integer> baseballNumber = gameHost.getBaseballNumber();
            boolean result = InputUtils.isNotDuplicatedNumber(baseballNumber);
            assertThat(result).isTrue();
        }
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class TestGetHint {
        GameHost gameHost = new GameHost();

        @BeforeAll
        void beforeAll() {
            List<Integer> baseballNumber = List.of(1, 2, 3);
            gameHost.setBaseballNumber(baseballNumber);
        }

        @Test
        @DisplayName("낫싱인 경우")
        void case1() {
            List<Integer> playerNumber = List.of(4, 5, 6);
            gameHost.setHint(playerNumber);
            String result = gameHost.getHint();
            assertThat(result).isEqualTo("낫싱");
        }

        @Test
        @DisplayName("1볼인 경우")
        void case2() {
            List<Integer> playerNumber = List.of(3, 6, 7);
            gameHost.setHint(playerNumber);
            String result = gameHost.getHint();
            assertThat(result).isEqualTo("1볼");
        }

        @Test
        @DisplayName("2볼인 경우")
        void case3() {
            List<Integer> playerNumber = List.of(3, 1, 7);
            gameHost.setHint(playerNumber);
            String result = gameHost.getHint();
            assertThat(result).isEqualTo("2볼");
        }

        @Test
        @DisplayName("3볼인 경우")
        void case4() {
            List<Integer> playerNumber = List.of(3, 1, 2);
            gameHost.setHint(playerNumber);
            String result = gameHost.getHint();
            assertThat(result).isEqualTo("3볼");
        }

        @Test
        @DisplayName("2볼 1스트라이크인 경우")
        void case5() {
            List<Integer> playerNumber = List.of(1, 3, 2);
            gameHost.setHint(playerNumber);
            String result = gameHost.getHint();
            assertThat(result).isEqualTo("2볼 1스트라이크");
        }

        @Test
        @DisplayName("2스트라이크인 경우")
        void case6() {
            List<Integer> playerNumber = List.of(1, 9, 3);
            gameHost.setHint(playerNumber);
            String result = gameHost.getHint();
            assertThat(result).isEqualTo("2스트라이크");
        }

        @Test
        @DisplayName("3스트라이크인 경우")
        void case7() {
            List<Integer> playerNumber = List.of(1, 2, 3);
            gameHost.setHint(playerNumber);
            String result = gameHost.getHint();
            assertThat(result).isEqualTo("3스트라이크");
        }
    }
}
