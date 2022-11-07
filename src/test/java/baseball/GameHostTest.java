package baseball;

import org.junit.jupiter.api.*;

import java.util.List;
import static org.assertj.core.api.Assertions.*;


public class GameHostTest {
    @Nested
    class TestIsValidBaseballNumber {
        GameHost gameHost = new GameHost();

//        @Test
//        @DisplayName("세 자리 난수 생성 시 예외 처리에 대해 테스트합니다.")
//        void case1() {
//            gameHost.setBaseballNumber();
//            List<Integer> baseballNumber = gameHost.getBaseballNumber();
//            boolean result = gameHost.isValidBaseballNumber(baseballNumber);
//            assertThat(result).isTrue();
//        }
//
//        @Test
//        void case2() {
//            List<Integer> baseballNumber = List.of(1, 2, 3, 4);
//            boolean result = gameHost.isValidBaseballNumber(baseballNumber);
//            assertThat(result).isFalse();
//        }
//
//        @Test
//        void case3() {
//            List<Integer> baseballNumber = List.of(1, 1, 2);
//            boolean result = gameHost.isValidBaseballNumber(baseballNumber);
//            assertThat(result).isFalse();
//        }
//
//        @Test
//        void case4() {
//            List<Integer> baseballNumber = List.of(0, 1, 2);
//            boolean result = gameHost.isValidBaseballNumber(baseballNumber);
//            assertThat(result).isFalse();
//        }
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
