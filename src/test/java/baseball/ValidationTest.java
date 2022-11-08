package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidationTest {

    @Test
    void restartNumber_숫자_외의_문자검증() {
        String english = "a";
        String korean = "가";

        assertThatThrownBy(() -> Validation.validateRestartNumber(english))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Number must be digit");
        assertThatThrownBy(() -> Validation.validateRestartNumber(korean))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Number must be digit");
    }

    @Test
    void restartNumber_숫자_개수검증() {
        //given
        String number1 = "12";
        String number2 = "345";

        //when, then
        assertThatThrownBy(() -> Validation.validateRestartNumber(number1))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Number must be correct-digit size: " + 1);
        assertThatThrownBy(() -> Validation.validateRestartNumber(number2))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Number must be correct-digit size: " + 1);
    }

    @Test
    void restartNumber_숫자_범위검증() {
        for (int number = 3; number <= 9; number++) {
            //given
            String stringNumber = String.valueOf(number);
            //when,then
            assertThatThrownBy(() -> Validation.validateRestartNumber(stringNumber))
                    .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Number is out of range");
        }
    }

    @Test
    void userNumber_숫자_0_검증() {
        //given
        String fistZeroNumber = "012";
        String middleZeroNumber = "103";
        String endZeroNumber = "340";

        //when, then
        assertThatThrownBy(() -> Validation.validateUserNumber(fistZeroNumber))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Number is out of range");
        assertThatThrownBy(() -> Validation.validateUserNumber(middleZeroNumber))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Number is out of range");
        assertThatThrownBy(() -> Validation.validateUserNumber(endZeroNumber))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Number is out of range");
    }

    @Test
    void userNumber_중복된_숫자_2개_입력() {
        //given
        String firstMiddleNumber = "112";
        String middleEndNumber = "233";
        String firstEndNumber = "191";


        //when, then
        assertThatThrownBy(() -> Validation.validateUserNumber(firstMiddleNumber))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UserNumber has duplicate number");
        assertThatThrownBy(() -> Validation.validateUserNumber(middleEndNumber))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UserNumber has duplicate number");
        assertThatThrownBy(() -> Validation.validateUserNumber(firstEndNumber))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UserNumber has duplicate number");
    }
    @Test
    void userNumber_중복된_숫자_3개_입력() {
        //given
        String givenNumber = "111";
        String givenNumber2 = "222";

        //when, then
        assertThatThrownBy(() -> Validation.validateUserNumber(givenNumber))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UserNumber has duplicate number");
        assertThatThrownBy(() -> Validation.validateUserNumber(givenNumber2))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UserNumber has duplicate number");
    }

    @Test
    void userNumber_자리수_3개_초과() {
        //given
        String givenNumber1 = "1234";
        String givenNumber2 = "987654";

        //when, then
        assertThatThrownBy(() -> Validation.validateUserNumber(givenNumber1))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Number must be correct-digit size: " + 3);
        assertThatThrownBy(() -> Validation.validateUserNumber(givenNumber2))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Number must be correct-digit size: " + 3);
    }
    @Test
    void userNumber_자리수_3개_미만() {
        //given
        String givenNumber1 = "12";
        String givenNumber2 = "5";

        //when, then
        assertThatThrownBy(() -> Validation.validateUserNumber(givenNumber1))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Number must be correct-digit size: " + 3);
        assertThatThrownBy(() -> Validation.validateUserNumber(givenNumber2))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Number must be correct-digit size: " + 3);
    }

    @Test
    void userNumber_숫자_외의_문자검증() {
        String english = "abc";
        String korean = "가나다";

        assertThatThrownBy(() -> Validation.validateUserNumber(english))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Number must be digit");
        assertThatThrownBy(() -> Validation.validateUserNumber(korean))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Number must be digit");
    }
}