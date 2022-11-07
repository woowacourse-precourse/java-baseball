package baseball.Input;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputNumberVerificationTest {
    InputNumberVerification inputNumberVerification = new InputNumberVerification();

    @Nested
    class verifyNumberTest {

        @Test
        void 숫자_4개_입력될_경우_예외_처리한다() {
            int number = 1234;

            assertThatThrownBy(() -> inputNumberVerification.verifyNumber(number))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("3개의 숫자만 입력해주세요");
        }

        @Test
        void 숫자_2개_입력될_경우_예외_처리한다() {
            int number = 12;

            assertThatThrownBy(() -> inputNumberVerification.verifyNumber(number))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("3개의 숫자만 입력해주세요");
        }

        @Test
        void 숫자_1개_입력될_경우_예외_처리한다() {
            int number = 1;

            assertThatThrownBy(() -> inputNumberVerification.verifyNumber(number))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("3개의 숫자만 입력해주세요");
        }

        @Test
        void 중복된_숫자_입력될_경우_예외_처리한다() {
            int number = 112;

            assertThatThrownBy(() -> inputNumberVerification.verifyNumber(number))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("각자 다른 숫자를 입력해주세요");
        }

        @Test
        void 숫자_한개씩_1부터_9_사이에_숫자가_아닌_경우_예외_처리한다() {
            int number = 160;

            assertThatThrownBy(() -> inputNumberVerification.verifyNumber(number))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("1~9 사이의 숫자만 입력해주세요");
        }
    }

    @Nested
    class verifyOneOrTwoButtonTest {

        @Test
        void 숫자_1_또는_2가_아닌_3이_입력될_경우_false() {
            int testNumber = 3;
            assertThatThrownBy(() -> inputNumberVerification.verifyOneOrTwoButton(testNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("1, 2 둘 중 하나만 고르세요");
        }

        @Test
        void 숫자_1_또는_2가_아닌_0이_입력될_경우_false() {
            int testNumber = 0;
            assertThatThrownBy(() -> inputNumberVerification.verifyOneOrTwoButton(testNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("1, 2 둘 중 하나만 고르세요");
        }

        @Test
        void 숫자_1_또는_2가_아닌_음수가_입력될_경우_false() {
            int testNumber = -1;
            assertThatThrownBy(() -> inputNumberVerification.verifyOneOrTwoButton(testNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("1, 2 둘 중 하나만 고르세요");
        }
    }

}