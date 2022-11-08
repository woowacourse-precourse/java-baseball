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
            assertThat(baseballNumbers.isNumericReadline(input))
                    .isTrue();
        }

        @Test
        void case2_4자리_숫자_입력() {
            String input = "1234";
            assertThat(baseballNumbers.isNumericReadline(input))
                    .isFalse();
        }

        @Test
        void case3_2자리_숫자_입력() {
            String input = "12";
            assertThat(baseballNumbers.isNumericReadline(input))
                    .isFalse();
        }

    }

    @Nested
    class 입력값이_RECORDS_명령어인지_확인 {

        @Test
        void case1_records_소문자_명령어_입력() {
            String input = "records";
            assertThat(baseballNumbers.isCommandReadline(input))
                    .isTrue();
        }

        @Test
        void case2_records_대문자_명령어_입력() {
            String input = "RECORDS";
            assertThat(baseballNumbers.isCommandReadline(input))
                    .isTrue();
        }

        @Test
        void case3_명령어_외_다른_문자_입력() {
            String input = "record";
            assertThat(baseballNumbers.isNumericReadline(input))
                    .isFalse();
        }

    }

    @Nested
    class 입력값이_3자리_숫자인지_또는_RECORDS_명령어인지_확인 {

        @Test
        void case1_3자리_숫자_입력() {
            String input = "123";
            assertThat(baseballNumbers.validateReadline(input))
                    .isTrue();
        }

        @Test
        void case2_RECORDS_명령어_입력() {
            String input = "records";
            assertThat(baseballNumbers.validateReadline(input))
                    .isTrue();
        }

        @Test
        void case3_그_외_입력() {
            String input = "1234";
            assertThat(baseballNumbers.validateReadline(input))
                    .isFalse();
        }

    }

    @Nested
    class 입력값이_IllegalArgumentException인지_확인 {

        @Test
        void case1_3자리_숫자_입력() {
            String input = "123";
            assertThat(baseballNumbers.checkReadline(input))
                    .isTrue();
        }

        @Test
        void case2_records_소문자_명령어_입력() {
            String input = "records";
            assertThat(baseballNumbers.checkReadline(input))
                    .isFalse();
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

    @Nested
    class 입력숫자의_요소가_중복인지_확인 {

        @Test
        void case1_중복된_숫자_2개_입력() {
            baseballNumbers.putBaseballNumbers("112".split("(?<=.)"));
            assertThatThrownBy(() -> baseballNumbers.validateDuplication())
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void case2_중복된_숫자_3개_입력() {
            baseballNumbers.putBaseballNumbers("111".split("(?<=.)"));
            assertThatThrownBy(() -> baseballNumbers.validateDuplication())
                    .isInstanceOf(IllegalArgumentException.class);
        }

    }

    @Nested
    class 입력값이_숫자면_생성_RECORDS면_false_반환 {

        @Test
        void case1_숫자_입력() {
            String input = "123";
            assertThat(baseballNumbers.createBaseballNumbers(input))
                    .isTrue();
        }

        @Test
        void case2_RECORDS_입력() {
            String input = "records";
            assertThat(baseballNumbers.createBaseballNumbers(input))
                    .isFalse();
        }

        @Test
        void case3_그_외_입력() {
            String input = "input";
            assertThatThrownBy(() -> baseballNumbers.createBaseballNumbers(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
