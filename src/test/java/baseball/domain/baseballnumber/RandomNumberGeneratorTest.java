package baseball.domain.baseballnumber;

import static baseball.domain.baseballnumber.RandomNumberGenerator.randomNumbers;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class RandomNumberGeneratorTest {

    @DisplayName("정해진 개수의 숫자가 생성된다")
    @RepeatedTest(3)
    void test1() {
        List<Integer> baseballNumbers = randomNumbers();
        assertThat(baseballNumbers.size()).isEqualTo(3);
    }

    @DisplayName("추출한 숫자는 서로 다르다")
    @RepeatedTest(3)
    void test2() {
        List<Integer> baseballNumbers = randomNumbers();
        long count = baseballNumbers.stream()
                .distinct()
                .count();

        assertThat(count).isEqualTo(3);
    }
}