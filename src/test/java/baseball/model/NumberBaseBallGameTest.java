package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

class NumberBaseBallGameTest {
    @Test
    @DisplayName("정상 값 입력")
    void enter_Correct_InputNumber(){
        String inputNumber = "123";
        NumberBaseBallGame numberBaseBallGame = mock(NumberBaseBallGame.class);
        doNothing().when(numberBaseBallGame).validateInputNumber(inputNumber);
    }

    @Test
    @DisplayName("3자리 미만의 값 입력시 에러")
    void enter_LessThreeLength_InputNumber(){
        String inputNumber = "12";
        failValidateInputNumber(inputNumber);
    }

    @Test
    @DisplayName("4자리 이상의 값 입력시 에러")
    void enter_OverFourLength_InputNumber(){
        String inputNumber = "1234";
        failValidateInputNumber(inputNumber);
    }

    @Test
    @DisplayName("문자가 포함된 값 입력시 에러")
    void enter_InputNumber_WithString(){
        String inputNumber = "12s";
        failValidateInputNumber(inputNumber);
    }

    private void failValidateInputNumber(String inputNumber) {
        NumberBaseBallGame numberBaseBallGame = new NumberBaseBallGame();
        assertThatThrownBy(() -> numberBaseBallGame.validateInputNumber(inputNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("서로 다른 3개의 자연수를 입력하세요");
    }
}