package baseball;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class IntComparatorTest {
    @CsvSource(value = {"1, 1, true", "1, 0, false", "1, 2, false"})
    @ParameterizedTest
    void returnTrue(int num1, int num2, boolean expected) {
        assertThat(IntComparator.isEqual(num1, num2)).isEqualTo(expected);
    }
}