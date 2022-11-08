package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BaseballNumberTest {
    @Nested
    @DisplayName("세자리 수는 0, 1, 2 인덱스에 대해 올바른 자리수 값을 반환하는지 테스트한다")
    class GetNumberAt {
        @ParameterizedTest
        @CsvSource(value = {"123, 0, 1", "123, 1, 2", "123, 2, 3"})
        void threeDigitsTest(int number, int index, int expected) {
            BaseballNumber baseballNumber = new BaseballNumber(number);
            assertThat(baseballNumber.getNumberAt(index)).isEqualTo(expected);
        }
    }

    @Nested
    @DisplayName("BaseballNumber가 해당 number를 가지고 있다면 true를 반환하는지 테스트한다")
    class Contains {
        @ParameterizedTest
        @CsvSource(value = {"123, 1, true", "324, 4, true", "589, 2, false"})
        void containsTest(int number, int target, boolean expected) {
            BaseballNumber baseballNumber = new BaseballNumber(number);
            assertThat(baseballNumber.contains(target)).isEqualTo(expected);
        }
    }
}