package baseball.domain.number.randomnumber;

import baseball.domain.number.SingleNumber;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static baseball.domain.number.randomnumber.RandomNumberFactory.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RandomNumberFactoryTest {

    private static final int DIGITS_FOR_THIS_GAME = 3;

    @Nested  // 줄인다.
    class 정해진_개수의_숫자가_생성된다 {
        @RepeatedTest(3)
        void 정해진_개수의_숫자가_생성된다() {
            List<SingleNumber> answer = newInstance().randomNumbers();
            assertThat(answer).hasSize(DIGITS_FOR_THIS_GAME);
        }
    }

    @Nested
    class 추출한_숫자는_서로_다르다 {
        @RepeatedTest(3)
        void 추출한_숫자는_서로_다르다() {
            List<SingleNumber> answer = newInstance().randomNumbers();
            long count = answer.stream()
                    .distinct()
                    .count();

            assertThat(count).isEqualTo(DIGITS_FOR_THIS_GAME);
        }
    }

    @Test
    void 만들어진_RandomNumber를_변경_시도할_경우_예외를_던진다() {
        List<SingleNumber> answer = newInstance().randomNumbers();

        assertThatThrownBy(() -> answer.add(new SingleNumber(1, 2)))
                .isInstanceOf(UnsupportedOperationException.class);

        assertThatThrownBy(() -> answer.remove(0))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}