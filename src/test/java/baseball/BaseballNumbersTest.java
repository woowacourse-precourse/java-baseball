package baseball;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballNumbersTest {
    BaseballNumbers baseballNumbers = new BaseballNumbers();

    @Nested
    class 입력값이_3자리_숫자인지_확인 {

        @Test
        void case1_3자리_숫자_입력() {
            String input = "123";
            boolean result = true;
            assertThat(baseballNumbers.isNumericReadline(input)).isEqualTo(result);
        }

        @Test
        void case2_4자리_숫자_입력() {
            String input = "1234";
            boolean result = false;
            assertThat(baseballNumbers.isNumericReadline(input)).isEqualTo(result);
        }

        @Test
        void case3_2자리_숫자_입력() {
            String input = "12";
            boolean result = false;
            assertThat(baseballNumbers.isNumericReadline(input)).isEqualTo(result);
        }

    }

}
