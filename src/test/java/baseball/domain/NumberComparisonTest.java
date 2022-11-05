package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NumberComparisonTest {

    private NumberComparison numberComparison;

    @BeforeEach
    void setUp() {
        numberComparison = new NumberComparison();
    }

    @Test
    void 컴퓨터와_플레이어_사이에_서로_포함된_숫자가_모두_맞을_경우() {
        int result = 3;
        int compare = numberComparison.compare(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3));
        assertThat(compare).isEqualTo(result);
    }

    @Test
    void 컴퓨터와_플레이어_사이에_서로_포함된_숫자가_2개_맞을_경우() {
        int result = 2;
        int compare = numberComparison.compare(Arrays.asList(1, 2, 5), Arrays.asList(1, 2, 3));
        assertThat(compare).isEqualTo(result);
    }

    @Test
    void 컴퓨터와_플레이어_사이에_서로_포함된_숫자가_1개_맞을_경우() {
        int result = 1;
        int compare = numberComparison.compare(Arrays.asList(1, 9, 5), Arrays.asList(1, 2, 3));
        assertThat(compare).isEqualTo(result);
    }

    @Test
    void 컴퓨터와_플레이어_사이에_서로_포함된_숫자가_없을_경우() {
        int result = 0;
        int compare = numberComparison.compare(Arrays.asList(4, 9, 5), Arrays.asList(1, 2, 3));
        assertThat(compare).isEqualTo(result);
    }
}