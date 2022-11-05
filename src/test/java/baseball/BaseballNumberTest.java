package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class BaseballNumberTest {
    @Nested
    class GetNumberAt {
        @DisplayName("세자리 수는 0, 1, 2 인덱스에 대해 올바른 자리수 값을 반환한다")
        @ParameterizedTest
        @CsvSource(value = {"123, 0, 1", "123, 1, 2", "123, 2, 3"})
        void threeDigitsTest(int number, int index, int expected) {
            BaseballNumber baseballNumber = new BaseballNumber(number);
            assertThat(baseballNumber.getNumberAt(index)).isEqualTo(expected);
        }
    }
}