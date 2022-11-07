package baseball;

import baseball.domain.Comparator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

class ComparatorTest {

    public ComparatorTest() {
        스트라이크 스트라이크 = new 스트라이크();
        볼 볼 = new 볼();
        볼_스트라이크 볼_스트라이크 = new 볼_스트라이크();
        낫싱();
        스트라이크.스트라이크1();
        스트라이크.스트라이크2();
        스트라이크.스트라이크3();
        볼.볼1();
        볼.볼2();
        볼.볼3();
        볼_스트라이크.볼1_스트라이크1();
        볼_스트라이크.볼2_스트라이크1();
    }

    @Test
    void 낫싱() {
        List<Integer> computerNumbers = List.of(1, 2, 3);
        List<Integer> playerNumbers = List.of(4, 5, 6);
        Comparator comparator = new Comparator(computerNumbers, playerNumbers);
        int[] result = comparator.getResult();
        int ball = result[0];
        int strike = result[1];
        Assertions.assertThat(ball).isZero();
        Assertions.assertThat(strike).isZero();
    }

    @Nested
    class 스트라이크 {
        @Test
        void 스트라이크1() {
            List<Integer> computerNumbers = List.of(1, 2, 3);
            List<Integer> playerNumbers = List.of(1, 4, 5);
            Comparator comparator = new Comparator(computerNumbers, playerNumbers);
            int[] result = comparator.getResult();
            int ball = result[0];
            int strike = result[1];
            Assertions.assertThat(ball).isZero();
            Assertions.assertThat(strike).isEqualTo(1);
        }

        @Test
        void 스트라이크2() {
            List<Integer> computerNumbers = List.of(1, 2, 3);
            List<Integer> playerNumbers = List.of(1, 2, 4);
            Comparator comparator = new Comparator(computerNumbers, playerNumbers);
            int[] result = comparator.getResult();
            int ball = result[0];
            int strike = result[1];
            Assertions.assertThat(ball).isZero();
            Assertions.assertThat(strike).isEqualTo(2);
        }

        @Test
        void 스트라이크3() {
            List<Integer> computerNumbers = List.of(1, 2, 3);
            List<Integer> playerNumbers = List.of(1, 2, 3);
            Comparator comparator = new Comparator(computerNumbers, playerNumbers);
            int[] result = comparator.getResult();
            int ball = result[0];
            int strike = result[1];
            Assertions.assertThat(ball).isZero();
            Assertions.assertThat(strike).isEqualTo(3);
        }
    }

    @Nested
    class 볼 {
        @Test
        void 볼1() {
            List<Integer> computerNumbers = List.of(1, 2, 3);
            List<Integer> playerNumbers = List.of(4, 1, 5);
            Comparator comparator = new Comparator(computerNumbers, playerNumbers);
            int[] result = comparator.getResult();
            int ball = result[0];
            int strike = result[1];
            Assertions.assertThat(ball).isEqualTo(1);
            Assertions.assertThat(strike).isZero();
        }

        @Test
        void 볼2() {
            List<Integer> computerNumbers = List.of(1, 2, 3);
            List<Integer> playerNumbers = List.of(4, 1, 2);
            Comparator comparator = new Comparator(computerNumbers, playerNumbers);
            int[] result = comparator.getResult();
            int ball = result[0];
            int strike = result[1];
            Assertions.assertThat(ball).isEqualTo(2);
            Assertions.assertThat(strike).isZero();
        }

        @Test
        void 볼3() {
            List<Integer> computerNumbers = List.of(1, 2, 3);
            List<Integer> playerNumbers = List.of(3, 1, 2);
            Comparator comparator = new Comparator(computerNumbers, playerNumbers);
            int[] result = comparator.getResult();
            int ball = result[0];
            int strike = result[1];
            Assertions.assertThat(ball).isEqualTo(3);
            Assertions.assertThat(strike).isZero();
        }
    }

    @Nested
    class 볼_스트라이크 {
        @Test
        void 볼1_스트라이크1() {
            List<Integer> computerNumbers = List.of(1, 2, 3);
            List<Integer> playerNumbers = List.of(1, 3, 4);
            Comparator comparator = new Comparator(computerNumbers, playerNumbers);
            int[] result = comparator.getResult();
            int ball = result[0];
            int strike = result[1];
            Assertions.assertThat(ball).isEqualTo(1);
            Assertions.assertThat(strike).isEqualTo(1);
        }

        @Test
        void 볼2_스트라이크1() {
            List<Integer> computerNumbers = List.of(1, 2, 3);
            List<Integer> playerNumbers = List.of(1, 3, 2);
            Comparator comparator = new Comparator(computerNumbers, playerNumbers);
            int[] result = comparator.getResult();
            int ball = result[0];
            int strike = result[1];
            Assertions.assertThat(ball).isEqualTo(2);
            Assertions.assertThat(strike).isEqualTo(1);
        }

    }
}
