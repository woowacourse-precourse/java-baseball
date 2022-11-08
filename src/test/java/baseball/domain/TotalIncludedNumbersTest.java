package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TotalIncludedNumbersTest {

    private TotalIncludedNumbers totalIncludedNumbers;

    @BeforeEach
    void setUp() {
        totalIncludedNumbers = new TotalIncludedNumbers();
    }

    @Test
    void 컴퓨터와_플레이어_사이에_서로_포함된_숫자가_모두_맞을_경우() {
        int result = 3;
        int compare = totalIncludedNumbers.compare(List.of(1, 2, 3), List.of(1, 2, 3));
        assertThat(compare).isEqualTo(result);
    }

    @Test
    void 컴퓨터와_플레이어_사이에_서로_포함된_숫자가_2개_맞을_경우() {
        int result = 2;
        int compare = totalIncludedNumbers.compare(List.of(1, 2, 3), List.of(1, 2, 5));
        assertThat(compare).isEqualTo(result);
    }

    @Test
    void 컴퓨터와_플레이어_사이에_서로_포함된_숫자가_1개_맞을_경우() {
        int result = 1;
        int compare = totalIncludedNumbers.compare(List.of(1, 2, 3), List.of(1, 9, 5));
        assertThat(compare).isEqualTo(result);
    }

    @Test
    void 컴퓨터와_플레이어_사이에_서로_포함된_숫자가_없을_경우() {
        int result = 0;
        int compare = totalIncludedNumbers.compare(List.of(1, 2, 3), List.of(4, 9, 5));
        assertThat(compare).isEqualTo(result);
    }
}
