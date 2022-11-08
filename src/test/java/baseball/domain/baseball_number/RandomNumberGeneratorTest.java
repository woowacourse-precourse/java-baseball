package baseball.domain.baseball_number;

import static baseball.domain.baseball_number.RandomNumberGenerator.randomNumbers;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;

class RandomNumberGeneratorTest {

    @Nested
    class 정해진_개수의_숫자가_생성된다 {
        @RepeatedTest(3)
        void 정해진_개수의_숫자가_생성된다() {
            List<Integer> baseballNumbers = randomNumbers();
            assertThat(baseballNumbers.size()).isEqualTo(3);
        }
    }

    @Nested
    class 추출한_숫자는_서로_다르다 {
        @RepeatedTest(3)
        void 추출한_숫자는_서로_다르다() {
            List<Integer> baseballNumbers = randomNumbers();
            long count = baseballNumbers.stream()
                    .distinct()
                    .count();

            assertThat(count).isEqualTo(3);
        }
    }

}