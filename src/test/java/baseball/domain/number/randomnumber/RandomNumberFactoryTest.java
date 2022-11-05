package baseball.domain.number.randomnumber;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;

import static baseball.domain.number.randomnumber.RandomNumberFactory.newInstance;
import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberFactoryTest {

    private static final int DIGITS_FOR_THIS_GAME = 3;

    @Nested  // 줄인다.
    class 정해진_개수의_숫자가_생성된다 {
        @RepeatedTest(3)
        void 정해진_개수의_숫자가_생성된다() {
            RandomNumbers randomNumbers = newInstance();
            assertThat(randomNumbers.size()).isEqualTo(3);
        }
    }

    @Nested
    class 추출한_숫자는_서로_다르다 {
        @RepeatedTest(3)
        void 추출한_숫자는_서로_다르다() {
            RandomNumbers randomNumbers = newInstance();
            assertThat(randomNumbers.countSingleNumbers()).isEqualTo(3);
        }
    }
}