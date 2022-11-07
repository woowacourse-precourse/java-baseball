package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class InputValidationTest {

    InputValidation inputValidation = new InputValidation();

    @Test
    public void 야구게임_사용자입력_검증1_숫자가_아닐_경우() {
        //given
        String userInput1 = "aaa";
        String userInput2 = "1a2";

        //when

        //then
        assertThatThrownBy(() -> inputValidation.validateInput(userInput1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputValidation.validateInput(userInput2))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    public void 야구게임_사용자입력_검증2_3글자가_아닐_경우() {
        //given
        String userInput1 = "1234";
        String userInput2 = "12";

        //when

        //then
        assertThatThrownBy(() -> inputValidation.validateInput(userInput1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputValidation.validateInput(userInput2))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    public void 야구게임_사용자입력_검증3_연속된_숫자_입력() {
        //given
        String userInput1 = "122";
        String userInput2 = "111";

        //when

        //then
        assertThatThrownBy(() -> inputValidation.validateInput(userInput1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputValidation.validateInput(userInput2))
                .isInstanceOf(IllegalArgumentException.class);

    }

}