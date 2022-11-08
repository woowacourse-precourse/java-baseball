package baseball.domain.user;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OpponentTest {
    @DisplayName("무작위 3자리수가 리스트에 삽입된다.")
    @Nested
    class Random {
        private Opponent opponent;

        @BeforeEach
        void init() {
            opponent = new Opponent();
        }

        @DisplayName("각각 다른 숫자가 삽입된다")
        @RepeatedTest(5)
        void diff() {
            List<Integer> goal = opponent.getGoal();

            List<Integer> buffer = new ArrayList<>();

            for (Integer baseballNum : goal) {
                assertThat(buffer.contains(baseballNum)).isFalse();
                buffer.add(baseballNum);
            }
        }

        @DisplayName("세개의 수가 삽입된다")
        @Test
        void isThreeElement() {
            List<Integer> goal = opponent.getGoal();
            assertThat(goal.size()).isEqualTo(3);
        }
    }
}