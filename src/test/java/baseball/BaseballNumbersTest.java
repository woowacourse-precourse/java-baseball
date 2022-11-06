package baseball;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Nested
    class 입력값이_RECORDS_명령어인지_확인 {

        @Test
        void case1_records_소문자_명령어_입력() {
            String input = "records";
            boolean result = true;
            assertThat(baseballNumbers.isCommandReadline(input)).isEqualTo(result);
        }

        @Test
        void case2_records_대문자_명령어_입력() {
            String input = "RECORDS";
            boolean result = true;
            assertThat(baseballNumbers.isCommandReadline(input)).isEqualTo(result);
        }

        @Test
        void case3_명령어_외_다른_문자_입력() {
            String input = "record";
            boolean result = false;
            assertThat(baseballNumbers.isNumericReadline(input)).isEqualTo(result);
        }

    }

    @Nested
    class 입력값이_3자리_숫자인지_또는_RECORDS_명령어인지_확인 {

        @Test
        void case1_3자리_숫자_입력() {
            String input = "123";
            boolean result = true;
            assertThat(baseballNumbers.validCheck(input)).isEqualTo(result);
        }

        @Test
        void case2_RECORDS_명령어_입력() {
            String input = "records";
            boolean result = true;
            assertThat(baseballNumbers.validCheck(input)).isEqualTo(result);
        }

        @Test
        void case3_그_외_입력() {
            String input = "1234";
            boolean result = false;
            assertThat(baseballNumbers.validCheck(input)).isEqualTo(result);
        }

    }

    @Nested
    class 입력값이_IllegalArgumentException인지_확인 {

        @Test
        void case1_3자리_숫자_입력() {
            String input = "123";
            boolean result = true;
            assertThat(baseballNumbers.checkReadline(input)).isEqualTo(result);
        }

        @Test
        void case2_records_소문자_명령어_입력() {
            String input = "records";
            boolean result = false;
            assertThat(baseballNumbers.checkReadline(input)).isEqualTo(result);
        }

        @Test
        void case3_명령어_외_다른_문자_입력() {
            String input = "record";
            assertThatThrownBy(() -> baseballNumbers.checkReadline(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void case4_1부터_9까지_범위_외_숫자_입력() {
            String input = "203";
            assertThatThrownBy(() -> baseballNumbers.checkReadline(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void case5_4자리_숫자_입력() {
            String input = "1234";
            assertThatThrownBy(() -> baseballNumbers.checkReadline(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void case6_2자리_숫자_입력() {
            String input = "12";
            assertThatThrownBy(() -> baseballNumbers.checkReadline(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

    }

}
