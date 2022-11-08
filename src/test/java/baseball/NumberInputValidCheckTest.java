package baseball;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class NumberInputValidCheckTest {
    @Test
    void 문자열입력시_예외발생(){
        wrongNumberInputTest("가나다");
        wrongNumberInputTest("   ");
    }
    @Test
    void 잘못된_자리수_입력시_예외발생(){
        wrongNumberInputTest("1234");
        wrongNumberInputTest("1");
    }
    @Test
    void 범위를_벗어나는_수_입력시_예외발생(){
        wrongNumberInputTest("102");
        wrongNumberInputTest("013");
        wrongNumberInputTest("120");
    }
    @Test
    void 중복되는_숫자_입력시_예외발생(){
        wrongNumberInputTest("121");
        wrongNumberInputTest("211");
        wrongNumberInputTest("112");
    }

    private void wrongNumberInputTest(String inputString){
        GameNumber gameNumber = new GameNumber();
        assertThrows(IllegalArgumentException.class, () -> {
            gameNumber.stringToGameNumber(inputString);
        });
    }
}
