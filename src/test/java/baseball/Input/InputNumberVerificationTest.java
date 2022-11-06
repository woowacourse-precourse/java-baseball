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
        @DisplayName("올바른 숫자 형식")
        void case1(){
            int number = 123;
            boolean result = InputNumberVerification.verifyNumber(number);
            assertEquals(true, result);
        }

        @Test
        @DisplayName("숫자 갯수가 3개가 아닌 4개인 경우")
        void case2(){
            int number = 1234;

            assertThatThrownBy(()-> InputNumberVerification.verifyNumber(number))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("3개의 숫자만 입력해주세요");
        }

        @Test
        @DisplayName("숫자 갯수가 3개가 아닌 2개인 경우")
        void case3(){
            int number = 12;

            assertThatThrownBy(()-> InputNumberVerification.verifyNumber(number))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("3개의 숫자만 입력해주세요");
        }

        @Test
        @DisplayName("숫자 갯수가 3개가 아닌 1개인 경우")
        void case4(){
            int number = 1;

            assertThatThrownBy(()-> InputNumberVerification.verifyNumber(number))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("3개의 숫자만 입력해주세요");
        }

        @Test
        @DisplayName("중복된 숫자가 있는 경우")
        void case5(){
            int number = 112;

            assertThatThrownBy(()-> InputNumberVerification.verifyNumber(number))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("각자 다른 숫자를 입력해주세요");
        }

        @Test
        @DisplayName("1~9 까지 숫자가 아닌 경우")
        void case6(){
            int number = 160;

            assertThatThrownBy(()-> InputNumberVerification.verifyNumber(number))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("1~9 사이의 숫자만 입력해주세요");
        }
    }

    @Nested
    class verifyOneOrTwoButtonTest{

        @Test
        void case1(){
            int testNumber = 1;
            boolean testResult = InputNumberVerification.verifyOneOrTwoButton(testNumber);
            assertEquals(true, testResult);
        }

        @Test
        void case2(){
            int testNumber = 2;
            boolean testResult = InputNumberVerification.verifyOneOrTwoButton(testNumber);
            assertEquals(true, testResult);
        }

        @Test
        void case3(){
            int testNumber = 3;
            boolean testResult = InputNumberVerification.verifyOneOrTwoButton(testNumber);
            assertEquals(false, testResult);
        }

        @Test
        void case4(){
            int testNumber = 0;
            boolean testResult = InputNumberVerification.verifyOneOrTwoButton(testNumber);
            assertEquals(false, testResult);
        }
    }

}