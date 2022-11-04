package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class ComputerTest {
    @Nested
    class TestIsValidBaseballNumber {
        @Test
        @DisplayName("세 자리 난수 생성 시 예외 처리에 대해 테스트합니다.")
        void case1() {
            Computer.setBaseballNumber();
            List<Integer> baseballNumber = Computer.getBaseballNumber();
            boolean result = Computer.isValidBaseballNumber(baseballNumber);
            final int THREEDIGITNUMBER = 3;
            assertThat(result);
        }

        @Test
        void case2() {
            List<Integer> baseballNumber = List.of(1, 2, 3, 4);
            boolean result = Computer.isValidBaseballNumber(baseballNumber);
            assertThat(!result);
        }

        @Test
        void case3() {
            List<Integer> baseballNumber = List.of(1, 1, 2);
            boolean result = Computer.isValidBaseballNumber(baseballNumber);
            assertThat(!result);
        }

        @Test
        void case4() {
            List<Integer> baseballNumber = List.of(0, 1, 2);
            boolean result = Computer.isValidBaseballNumber(baseballNumber);
            assertThat(!result);
        }
    }

    @Nested
    class TestGetHint{
        @Test
        @DisplayName("낫싱인 경우")
        void case1() {
            List<Integer> baseballNumber = List.of(1, 2, 3);
            List<Integer> playerNumber = List.of(4, 5, 6);

            void result = Computer.getHint(baseballNumber, playerNumber);
            assertThat(result).isEqualTo("낫싱");
        }

        @Test
        @DisplayName("1볼인 경우")
        void case2() {
            List<Integer> baseballNumber = List.of(1, 2, 3);
            List<Integer> playerNumber = List.of(3, 6, 7);
            String result = Computer.getHint(baseballNumber, playerNumber);
            assertThat(result).isEqualTo("1볼");
        }

        @Test
        @DisplayName("2볼인 경우")
        void case3() {
            List<Integer> baseballNumber = List.of(1, 2, 3);
            List<Integer> playerNumber = List.of(3, 1, 7);
            String result = Computer.getHint(baseballNumber, playerNumber);
            assertThat(result).isEqualTo("2볼");
        }

        @Test
        @DisplayName("3볼인 경우")
        void case4() {
            List<Integer> baseballNumber = List.of(1, 2, 3);
            List<Integer> playerNumber = List.of(3, 1, 2);
            String result = Computer.getHint(baseballNumber, playerNumber);
            assertThat(result).isEqualTo("3볼");
        }

        @Test
        @DisplayName("2볼 1스트라이크인 경우")
        void case5() {
            List<Integer> baseballNumber = List.of(1, 2, 3);
            List<Integer> playerNumber = List.of(1, 3, 2);
            String result = Computer.getHint(baseballNumber, playerNumber);
            assertThat(result).isEqualTo("2볼 1스트라이크");
        }

        @Test
        @DisplayName("2스트라이크인 경우")
        void case6() {
            List<Integer> baseballNumber = List.of(1, 2, 3);
            List<Integer> playerNumber = List.of(1, 9, 3);
            String result = Computer.getHint(baseballNumber, playerNumber);
            assertThat(result).isEqualTo("2스트라이크");
        }

        @Test
        @DisplayName("3스트라이크인 경우")
        void case7() {
            List<Integer> baseballNumber = List.of(1, 2, 3);
            List<Integer> playerNumber = List.of(1, 2, 3);
            String result = Computer.getHint(baseballNumber, playerNumber);
            assertThat(result).isEqualTo("3스트라이크");
        }
    }

}
