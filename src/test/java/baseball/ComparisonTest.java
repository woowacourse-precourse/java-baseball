package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComparisonTest {

    @Test
    void 숫자_리스트로_변환() {
        List<Integer> resultList = List.of(1, 2, 3);
        List<Integer> numberList = Comparison.numberToList(123);

        Assertions.assertThat(numberList).isEqualTo(resultList);
    }
}