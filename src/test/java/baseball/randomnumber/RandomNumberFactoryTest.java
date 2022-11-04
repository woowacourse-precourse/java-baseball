package baseball.randomnumber;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RandomNumberFactoryTest {

    private static final int DIGITS_FOR_THIS_GAME = 3;

    @Nested  // 줄인다.
    class 정해진_개수의_숫자가_생성된다 {
        @RepeatedTest(10)
        void 정해진_개수의_숫자가_생성된다() {
            List<Integer> answer = RandomNumberFactory.newRandomNumber();
            assertThat(answer.size()).isEqualTo(DIGITS_FOR_THIS_GAME);
        }
    }

    @Nested
    class 추출한_숫자는_서로_다르다 {
        @RepeatedTest(10)
        void 추출한_숫자는_서로_다르다() {
            List<Integer> answer = RandomNumberFactory.newRandomNumber();
            long count = answer.stream()
                    .distinct()
                    .count();

            assertThat(count).isEqualTo(DIGITS_FOR_THIS_GAME);
        }
    }

    @Test
    void 만들어진_RandomNumber를_바꿀수_없다() {
        List<Integer> answer = RandomNumberFactory.newRandomNumber();

        assertThatThrownBy(() -> answer.add(100))
                .isInstanceOf(UnsupportedOperationException.class);

        assertThatThrownBy(() -> answer.remove(0))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}