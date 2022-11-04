package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class IntComparatorTest {
    @CsvSource(value = {"1, 1, true", "1, 0, false", "1, 2, false"})
    @ParameterizedTest
    void returnTrue(int num1, int num2, boolean expect) {
        assertThat(IntComparator.isEqual(3, 3));
    }
}