package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;


class ComparisonTest {
    private static Comparison comparison;

    @BeforeAll
    public static void setUp() {
        comparison = new Comparison(123, 321, 3);
    }

    @Test
    void 숫자_리스트로_변환() {
        List<Integer> resultList = List.of(1, 2, 3);
        List<Integer> numberList = Comparison.numberToList(123);

        Assertions.assertThat(numberList).isEqualTo(resultList);
    }

    @Test
    void 스트라이크_개수_반환() {
        int result = 1;
        int strikeCount = comparison.getStrikeCount();

        Assertions.assertThat(strikeCount).isEqualTo(result);
    }

    @Test
    void 볼_개수_반환() {
        int result = 2;
        int ballCount = comparison.getBallCount();

        Assertions.assertThat(ballCount).isEqualTo(result);
    }
}