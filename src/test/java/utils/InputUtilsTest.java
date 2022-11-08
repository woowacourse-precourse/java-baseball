package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class InputUtilsTest {
    @Nested
    class TestIsDigit {
        @Test
        @DisplayName("입력값이 숫자인지")
        void case1() {
            String input = "1";
            assertThat(InputUtils.isDigit(input)).isTrue();
        }

        @Test
        @DisplayName("입력값이 문자인 경우")
        void case2() {
            String input = "숫자?";
            assertThat(InputUtils.isDigit(input)).isFalse();
        }
    }

    @Nested
    class TestIsDigitInValidRange {
        @Test
        @DisplayName("입력값이 1인 경우")
        void case1() {
            String input = "1";
            assertThat(InputUtils.isDigitInValidRange(input)).isTrue();
        }

        @Test
        @DisplayName("입력값이 2인 경우")
        void case2() {
            String input = "2";
            assertThat(InputUtils.isDigitInValidRange(input)).isTrue();
        }

        @Test
        @DisplayName("입력값이 1, 2가 아닌 경우")
        void case3() {
            String input = "6";
            assertThat(InputUtils.isDigitInValidRange(input)).isFalse();
        }
    }

    @Nested
    class TestChangeStringInputToList {
        @Test
        void case1() {
            String input = "123";
            List<Integer> result = List.of(1, 2, 3);
            assertThat(InputUtils.changeStringInputToList(input)).isEqualTo(result);
        }

        @Test
        void case2() {
            String input = "12dasdf";
            assertThatThrownBy(() -> InputUtils.changeStringInputToList(input))
                    .isInstanceOf(NumberFormatException.class);
        }
    }

    @Nested
    class TestIsBaseballNumberLength3 {
        @Test
        @DisplayName("입력값이 세 자리 정수인 경우")
        void case1() {
            String input = "123";
            assertThat(InputUtils.isBaseballNumberLength3(input)).isTrue();
        }

        @Test
        @DisplayName("입력값이 세 자리 초과인 경우")
        void case2() {
            String input = "123456";
            assertThat(InputUtils.isBaseballNumberLength3(input)).isFalse();
        }

        @Test
        @DisplayName("입력값이 세 자리 미만인 경우")
        void case3() {
            String input = "1";
            assertThat(InputUtils.isBaseballNumberLength3(input)).isFalse();
        }
    }

    @Nested
    class TestIsNotDuplicatedNumber {
        @Test
        @DisplayName("입력값이 중복되지 않은 경우")
        void case1() {
            String input = "123";
            assertThat(InputUtils.isNotDuplicatedNumber(input)).isTrue();
        }

        @Test
        @DisplayName("입력값이 중복된 경우")
        void case2() {
            String input = "111";
            assertThat(InputUtils.isNotDuplicatedNumber(input)).isFalse();
        }
    }

    @Nested
    class TestIsValidRange {
        @Test
        @DisplayName("입력값 1~9 사이에 있는 경우")
        void case1() {
            String input = "123";
            assertThat(InputUtils.isValidRange(input)).isTrue();
        }

        @Test
        @DisplayName("입력값이 범위에서 벗어난 경우")
        void case2() {
            String input = "019";
            assertThat(InputUtils.isValidRange(input)).isFalse();
        }
    }
}
