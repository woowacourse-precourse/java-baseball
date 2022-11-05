package baseball;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OpponentTest {
    @Test
    void 랜덤_생성되는_값_유효성_검증() {
        for (int i = 0; i < 1000; ++i) {
            Opponent opponent = new ComputerOpponent();
        }
    }

    @Nested
    @DisplayName("힌트 유효성 검증")
    class HintTest {
        @Test
        void 스트라이크_3번() {
            List<Integer> answer = List.of(1,2,3);
            List<Integer> input = List.of(1,2,3);

            Hint hint = new Hint(answer,input);
            assertThat(hint.toString()).isEqualTo("3스트라이크");
        }
        @Test
        void 스트라이크_2번() {
            List<Integer> answer = List.of(1,2,4);
            List<Integer> input = List.of(1,2,5);

            Hint hint = new Hint(answer,input);
            assertThat(hint.toString()).isEqualTo("2스트라이크");
        }
        @Test
        void 스트라이크_1번() {
            List<Integer> answer = List.of(1,2,7);
            List<Integer> input = List.of(1,4,5);

            Hint hint = new Hint(answer,input);
            assertThat(hint.toString()).isEqualTo("1스트라이크");
        }
        @Test
        void 볼_3번() {
            List<Integer> answer = List.of(1,2,3);
            List<Integer> input = List.of(2,3,1);

            Hint hint = new Hint(answer,input);
            assertThat(hint.toString()).isEqualTo("3볼");
        }
        @Test
        void 볼_2번() {
            List<Integer> answer = List.of(1,2,3);
            List<Integer> input = List.of(2,6,1);

            Hint hint = new Hint(answer,input);
            assertThat(hint.toString()).isEqualTo("2볼");
        }
        @Test
        void 볼_1번() {
            List<Integer> answer = List.of(1,2,3);
            List<Integer> input = List.of(2,5,6);

            Hint hint = new Hint(answer,input);
            assertThat(hint.toString()).isEqualTo("1볼");
        }
        @Test
        void 스트라이크_2번_볼_1번() {
            List<Integer> answer = List.of(1,2,3);
            List<Integer> input = List.of(1,2,1);

            Hint hint = new Hint(answer,input);
            assertThat(hint.toString()).isEqualTo("1볼 2스트라이크");
        }
        @Test
        void 스트라이크_1번_볼_2번() {
            List<Integer> answer = List.of(1,2,3);
            List<Integer> input = List.of(1,3,2);

            Hint hint = new Hint(answer,input);
            assertThat(hint.toString()).isEqualTo("2볼 1스트라이크");
        }
        @Test
        void 낫싱() {
            List<Integer> answer = List.of(1,2,3);
            List<Integer> input = List.of(4,5,6);

            Hint hint = new Hint(answer,input);
            assertThat(hint.toString()).isEqualTo("낫싱");
        }
    }

}
