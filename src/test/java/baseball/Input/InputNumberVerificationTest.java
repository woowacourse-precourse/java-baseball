package baseball.Input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputNumberVerificationTest {

    @Nested
    class verifyNumberTest {

        @Test
        void 올바른_숫자_형식일_경우_true() {
            int number = 123;
            boolean result = InputNumberVerification.verifyNumber(number);
            assertEquals(true, result);
        }

        @Test
        void 숫자_4개_입력될_경우_예외_처리한다() {
            int number = 1234;

            assertThatThrownBy(() -> InputNumberVerification.verifyNumber(number))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("3개의 숫자만 입력해주세요");
        }

        @Test
        void 숫자_2개_입력될_경우_예외_처리한다() {
            int number = 12;

            assertThatThrownBy(() -> InputNumberVerification.verifyNumber(number))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("3개의 숫자만 입력해주세요");
        }

        @Test
        void 숫자_1개_입력될_경우_예외_처리한다() {
            int number = 1;

            assertThatThrownBy(() -> InputNumberVerification.verifyNumber(number))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("3개의 숫자만 입력해주세요");
        }

        @Test
        void 중복된_숫자_입력될_경우_예외_처리한다() {
            int number = 112;

            assertThatThrownBy(() -> InputNumberVerification.verifyNumber(number))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("각자 다른 숫자를 입력해주세요");
        }

        @Test
        void 숫자_한개씩_1부터_9_사이에_숫자가_아닌_경우_예외_처리한다() {
            int number = 160;

            assertThatThrownBy(() -> InputNumberVerification.verifyNumber(number))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("1~9 사이의 숫자만 입력해주세요");
        }
    }

    @Nested
    class verifyOneOrTwoButtonTest {

        @Test
        void 숫자_1이_입력될_경우_true() {
            int testNumber = 1;
            boolean testResult = InputNumberVerification.verifyOneOrTwoButton(testNumber);
            assertEquals(true, testResult);
        }

        @Test
        void 숫자_2_입력될_경우_true() {
            int testNumber = 2;
            boolean testResult = InputNumberVerification.verifyOneOrTwoButton(testNumber);
            assertEquals(true, testResult);
        }

        @Test
        void 숫자_1_또는_2가_아닌_3이_입력될_경우_false() {
            int testNumber = 3;
            boolean testResult = InputNumberVerification.verifyOneOrTwoButton(testNumber);
            assertEquals(false, testResult);
        }

        @Test
        void 숫자_1_또는_2가_아닌_0이_입력될_경우_false() {
            int testNumber = 0;
            boolean testResult = InputNumberVerification.verifyOneOrTwoButton(testNumber);
            assertEquals(false, testResult);
        }
    }

}