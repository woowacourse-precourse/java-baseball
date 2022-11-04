package mytest;

import static org.assertj.core.api.Assertions.*;

import baseball.Calculator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @DisplayName("볼과 스트라이크의 개수가 주어진 결과와 일치하는지 확인")
    @Test
    void case1() {
        List<Integer> dealerNumbers = List.of(1, 3, 7);
        List<Integer> playerNumbers = List.of(1, 3, 7);
        List<Integer> result = List.of(0, 3);
        Calculator calculator = new Calculator(dealerNumbers, playerNumbers);

        assertThat(calculator.getScores()).isEqualTo(result);
    }

    @Test
    void case2() {
        List<Integer> dealerNumbers = List.of(4, 2, 5);
        List<Integer> playerNumbers = List.of(4, 5, 6);
        List<Integer> result = List.of(1, 1);
        Calculator calculator = new Calculator(dealerNumbers, playerNumbers);

        assertThat(calculator.getScores()).isEqualTo(result);
    }

    @Test
    void case3() {
        List<Integer> dealerNumbers = List.of(3, 4, 5);
        List<Integer> playerNumbers = List.of(7, 8, 9);
        List<Integer> result = List.of(0, 0);
        Calculator calculator = new Calculator(dealerNumbers, playerNumbers);

        assertThat(calculator.getScores()).isEqualTo(result);
    }

    @Test
    void case4() {
        List<Integer> dealerNumbers = List.of(5, 9, 8);
        List<Integer> playerNumbers = List.of(8, 5, 1);
        List<Integer> result = List.of(2, 0);
        Calculator calculator = new Calculator(dealerNumbers, playerNumbers);

        assertThat(calculator.getScores()).isEqualTo(result);
    }
}
