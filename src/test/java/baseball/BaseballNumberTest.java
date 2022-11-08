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

    @Nested
    class 메시지_출력 {
        @Test
        void 낫싱() {
            int strike = 0;
            int ball = 0;
            String message = BaseballNumber.getMessage(strike, ball);
            assertThat(message).isEqualTo("낫싱");
        }

        @Test
        void 볼() {
            int strike = 0;
            int ball = 2;
            String message = BaseballNumber.getMessage(strike, ball);
            assertThat(message).isEqualTo("2볼");
        }

        @Test
        void 스트라이크() {
            int strike = 2;
            int ball = 0;
            String message = BaseballNumber.getMessage(strike, ball);
            assertThat(message).isEqualTo("2스트라이크");
        }

        @Test
        void 스트라이크와_볼이_같이있는경우() {
            int strike = 2;
            int ball = 2;
            String message = BaseballNumber.getMessage(strike, ball);
            assertThat(message).isEqualTo("2볼 2스트라이크");
        }

        @Test
        void 정답() {
            int strike = 3;
            int ball = 0;
            String message = BaseballNumber.getMessage(strike, ball);
            assertThat(message).isEqualTo("3스트라이크");
        }
    }
}
