package baseball.domain.number.randomnumber;

import baseball.domain.randomnumber.RandomNumbers;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberFactoryTest {

    @Nested  // 줄인다.
    class 정해진_개수의_숫자가_생성된다 {
        @RepeatedTest(3)
        void 정해진_개수의_숫자가_생성된다() {
            RandomNumbers randomNumbers = new RandomNumbers();
            assertThat(randomNumbers.size()).isEqualTo(3);
        }
    }

    @Nested
    class 추출한_숫자는_서로_다르다 {
        @RepeatedTest(3)
        void 추출한_숫자는_서로_다르다() {
            RandomNumbers randomNumbers = new RandomNumbers();
            assertThat(randomNumbers.isDuplicated()).isFalse();
        }
    }
}