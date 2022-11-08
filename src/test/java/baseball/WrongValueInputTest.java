package baseball;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class WrongValueInputTest {
    @Test
    void 문자열입력시_예외발생(){
        checkWrongValueInput("가나다");
        checkWrongValueInput("   ");
    }
    @Test
    void 잘못된_자리수_입력시_예외발생(){
        checkWrongValueInput("1234");
        checkWrongValueInput("1");
    }
    @Test
    void 범위를_벗어나는_수_입력시_예외발생(){
        checkWrongValueInput("102");
        checkWrongValueInput("013");
        checkWrongValueInput("120");
    }
    @Test
    void 중복되는_숫자_입력시_예외발생(){
        checkWrongValueInput("121");
        checkWrongValueInput("211");
        checkWrongValueInput("112");
    }

    private void checkWrongValueInput(String inputString){
        GameNumber gameNumber = new GameNumber();
        assertThrows(IllegalArgumentException.class, () -> {
            gameNumber.stringToGameNumber(inputString);
        });
    }
}
