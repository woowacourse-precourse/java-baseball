package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class ComputerTest {
    @Nested
    class TestIsValidBaseballNumber {
        @Test
        @DisplayName("세 자리 난수 생성 시 예외 처리에 대해 테스트합니다.")
        void case1() {
            Computer.setBaseballNumber();
            List<Integer> baseballNumber = Computer.getBaseballNumber();
            boolean result = Computer.isValidBaseballNumber(baseballNumber);
            final int THREEDIGITNUMBER = 3;
            assertThat(result);
        }

        @Test
        void case2() {
            List<Integer> baseballNumber = List.of(1, 2, 3, 4);
            boolean result = Computer.isValidBaseballNumber(baseballNumber);
            assertThat(!result);
        }

        @Test
        void case3() {
            List<Integer> baseballNumber = List.of(1, 1, 2);
            boolean result = Computer.isValidBaseballNumber(baseballNumber);
            assertThat(!result);
        }

        @Test
        void case4() {
            List<Integer> baseballNumber = List.of(0, 1, 2);
            boolean result = Computer.isValidBaseballNumber(baseballNumber);
            assertThat(!result);
        }
    }

}
