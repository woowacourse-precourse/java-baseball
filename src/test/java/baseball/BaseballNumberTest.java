package baseball;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BaseballNumberTest {

    @Test
    void 생성된_숫자가_3자리수() {
        List<Integer> baseballNumber = BaseballNumber.create();
        assertThat(baseballNumber.size()).isEqualTo(3);
    }

    @Test
    void 각자리_숫자의_중복_여부_확인() {
        boolean hasSameNumber = false;
        List<Integer> baseballNumber = BaseballNumber.create();

        int onesPlace = baseballNumber.get(2);
        int tensPlace = baseballNumber.get(1);
        int hundredsPlace = baseballNumber.get(0);

        if (onesPlace == tensPlace) {
            hasSameNumber = true;
        }
        if (tensPlace == hundredsPlace) {
            hasSameNumber = true;
        }
        if (onesPlace == hundredsPlace) {
            hasSameNumber = true;
        }

        assertThat(hasSameNumber).isFalse();
    }

    @Nested
    class 스트라이크_개수_확인 {
        @Test
        void 스트라이크_X() {
            List<Integer> baseballNumber = List.of(1, 2, 3);
            List<Integer> inputNumber = List.of(3, 1, 2);
            int count = BaseballNumber.countStrike(baseballNumber, inputNumber);
            assertThat(count).isEqualTo(0);
        }
        @Test
        void 스트라이크_1개() {
            List<Integer> baseballNumber = List.of(1, 2, 3);
            List<Integer> inputNumber = List.of(3, 2, 1);
            int count = BaseballNumber.countStrike(baseballNumber, inputNumber);
            assertThat(count).isEqualTo(1);
        }
        @Test
        void 스트라이크_2개() {
            List<Integer> baseballNumber = List.of(1, 2, 3);
            List<Integer> inputNumber = List.of(1, 2, 4);
            int count = BaseballNumber.countStrike(baseballNumber, inputNumber);
            assertThat(count).isEqualTo(2);
        }
        @Test
        void 스트라이크_3개() {
            List<Integer> baseballNumber = List.of(1, 2, 3);
            List<Integer> inputNumber = List.of(1, 2, 3);
            int count = BaseballNumber.countStrike(baseballNumber, inputNumber);
            assertThat(count).isEqualTo(3);
        }
    }
    @Nested
    class 볼_개수_확인 {
        @Test
        void 볼_X() {
            List<Integer> baseballNumber = List.of(1, 2, 3);
            List<Integer> inputNumber = List.of(4, 5, 6);
            int count = BaseballNumber.countBall(baseballNumber, inputNumber);
            assertThat(count).isEqualTo(0);
        }
        @Test
        void 볼_1개() {
            List<Integer> baseballNumber = List.of(1, 2, 3);
            List<Integer> inputNumber = List.of(1, 3, 5);
            int count = BaseballNumber.countBall(baseballNumber, inputNumber);
            assertThat(count).isEqualTo(1);
        }
        @Test
        void 볼_2개() {
            List<Integer> baseballNumber = List.of(1, 2, 3);
            List<Integer> inputNumber = List.of(2, 1, 3);
            int count = BaseballNumber.countBall(baseballNumber, inputNumber);
            assertThat(count).isEqualTo(2);
        }
        @Test
        void 볼_3개() {
            List<Integer> baseballNumber = List.of(1, 2, 3);
            List<Integer> inputNumber = List.of(3, 1, 2);
            int count = BaseballNumber.countBall(baseballNumber, inputNumber);
            assertThat(count).isEqualTo(3);
        }
    }
}

