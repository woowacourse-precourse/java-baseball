package baseball.system;

import org.junit.jupiter.api.Test; // @Test annotation
import org.junit.jupiter.api.BeforeEach; // @BeforeEach annotation

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;


public class NumberComparisonTest {

    private NumberComparison numberComparison;


    @BeforeEach
    void createObject() {
        this.numberComparison = new NumberComparison(Arrays.asList(4, 3, 5));
    }

    @Test
    void 숫자_678과_비교() {
        boolean result = numberComparison.startComparison(Arrays.asList(6, 7, 8));

        assertThat(numberComparison.getBallCount()).isEqualTo(0);
        assertThat(numberComparison.getStrikeCount()).isEqualTo(0);

        assertThat(result).isFalse();
    }

    @Test
    void 숫자_123과_비교() {
        boolean result = numberComparison.startComparison(Arrays.asList(1, 2, 3));

        assertThat(numberComparison.getBallCount()).isEqualTo(1);
        assertThat(numberComparison.getStrikeCount()).isEqualTo(0);
        assertThat(result).isFalse();
    }

    @Test
    void 숫자_346과_비교() {
        boolean result = numberComparison.startComparison(Arrays.asList(3, 4, 6));

        assertThat(numberComparison.getBallCount()).isEqualTo(2);
        assertThat(numberComparison.getStrikeCount()).isEqualTo(0);
        assertThat(result).isFalse();
    }

    @Test
    void 숫자_543과_비교() {
        boolean result = numberComparison.startComparison(Arrays.asList(5, 4, 3));

        assertThat(numberComparison.getBallCount()).isEqualTo(3);
        assertThat(numberComparison.getStrikeCount()).isEqualTo(0);
        assertThat(result).isFalse();
    }

    @Test
    void 숫자_463과_비교() {
        boolean result = numberComparison.startComparison(Arrays.asList(4, 6, 3));

        assertThat(numberComparison.getBallCount()).isEqualTo(1);
        assertThat(numberComparison.getStrikeCount()).isEqualTo(1);
        assertThat(result).isFalse();
    }

    @Test
    void 숫자_453과_비교() {
        boolean result = numberComparison.startComparison(Arrays.asList(4, 5, 3));

        assertThat(numberComparison.getBallCount()).isEqualTo(2);
        assertThat(numberComparison.getStrikeCount()).isEqualTo(1);
        assertThat(result).isFalse();
    }

    @Test
    void 숫자_436과_비교() {
        boolean result = numberComparison.startComparison(Arrays.asList(4, 3, 6));

        assertThat(numberComparison.getBallCount()).isEqualTo(0);
        assertThat(numberComparison.getStrikeCount()).isEqualTo(2);
        assertThat(result).isFalse();
    }

    @Test
    void 숫자_435과_비교() {
        boolean result = numberComparison.startComparison(Arrays.asList(4, 3, 5));

        assertThat(numberComparison.getBallCount()).isEqualTo(0);
        assertThat(numberComparison.getStrikeCount()).isEqualTo(3);
        assertThat(result).isTrue();
    }

}
