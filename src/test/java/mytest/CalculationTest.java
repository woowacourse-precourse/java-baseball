package mytest;

import static org.assertj.core.api.Assertions.*;

import baseball.settings.Calculation;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculationTest {
    @DisplayName("볼과 스트라이크 개수가 예상한 결과와 일치하는지 확인")
    @Test
    void case1() {
        List<Integer> dealerNumbers = List.of(1, 3, 7);
        List<Integer> playerNumbers = List.of(1, 3, 7);
        List<Integer> actualResult = Calculation.getScoresBy(dealerNumbers, playerNumbers);
        List<Integer> expectedResult = List.of(0, 3);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void case2() {
        List<Integer> dealerNumbers = List.of(4, 2, 5);
        List<Integer> playerNumbers = List.of(4, 5, 6);
        List<Integer> actualResult = Calculation.getScoresBy(dealerNumbers, playerNumbers);
        List<Integer> expectedResult = List.of(1, 1);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void case3() {
        List<Integer> dealerNumbers = List.of(3, 4, 5);
        List<Integer> playerNumbers = List.of(7, 8, 9);
        List<Integer> actualResult = Calculation.getScoresBy(dealerNumbers, playerNumbers);
        List<Integer> expectedResult = List.of(0, 0);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void case4() {
        List<Integer> dealerNumbers = List.of(5, 9, 8);
        List<Integer> playerNumbers = List.of(8, 5, 1);
        List<Integer> actualResult = Calculation.getScoresBy(dealerNumbers, playerNumbers);
        List<Integer> expectedResult = List.of(2, 0);

        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
