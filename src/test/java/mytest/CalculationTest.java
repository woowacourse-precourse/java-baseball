package mytest;

import static org.assertj.core.api.Assertions.*;

import baseball.settings.Calculation;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculationTest {
    @DisplayName("계산 테스트 - 3스트라이크")
    @Test
    void case1() {
        List<Integer> dealerNumbers = List.of(1, 3, 7);
        List<Integer> playerNumbers = List.of(1, 3, 7);
        List<Integer> actualResult = Calculation.getScoresByNumbers(dealerNumbers, playerNumbers);
        List<Integer> expectedResult = List.of(0, 3);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @DisplayName("계산 테스트 - 1볼 1스트라이크")
    @Test
    void case2() {
        List<Integer> dealerNumbers = List.of(4, 2, 5);
        List<Integer> playerNumbers = List.of(4, 5, 6);
        List<Integer> actualResult = Calculation.getScoresByNumbers(dealerNumbers, playerNumbers);
        List<Integer> expectedResult = List.of(1, 1);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @DisplayName("계산 테스트 - 낫싱")
    @Test
    void case3() {
        List<Integer> dealerNumbers = List.of(3, 4, 5);
        List<Integer> playerNumbers = List.of(7, 8, 9);
        List<Integer> actualResult = Calculation.getScoresByNumbers(dealerNumbers, playerNumbers);
        List<Integer> expectedResult = List.of(0, 0);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @DisplayName("계산 테스트 - 2볼")
    @Test
    void case4() {
        List<Integer> dealerNumbers = List.of(5, 9, 8);
        List<Integer> playerNumbers = List.of(8, 5, 1);
        List<Integer> actualResult = Calculation.getScoresByNumbers(dealerNumbers, playerNumbers);
        List<Integer> expectedResult = List.of(2, 0);

        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
