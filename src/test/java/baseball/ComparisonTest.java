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

    @Test
    void 스트라이크_개수_반환(){
        int result = 1;
        int strikeCount = Comparison.getStrikeCount(123, 321);

        Assertions.assertThat(strikeCount).isEqualTo(result);
    }
}