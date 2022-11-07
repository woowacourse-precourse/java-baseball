package baseball.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputUtilTest {
    private final InputUtil inputUtil;
    InputUtilTest(){
        this.inputUtil = new InputUtil();
    }
    @Test
    void 유저_입력_테스트(){
        String input = "123";
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ArrayList<Integer> inputNumbers = inputUtil.inputUserNumbers();
        Assertions.assertEquals(inputNumbers, numbers);
    }

    @Test
    void 문자열_숫자_배열로_변경(){
        String input = "123";
        ArrayList<Integer> answer = new ArrayList<>(List.of(1,2,3));
        ArrayList<Integer> returnValue = inputUtil.parseStringToInt(input);
        Assertions.assertEquals(answer,returnValue);
    }

    @Test
    void 문자를_숫자로_변경(){
        char input = '1';
        int answer = 1;
        int returnValue = inputUtil.charToInt(input);
        Assertions.assertEquals(answer,returnValue);
    }

    @Test()
    void 숫자이외_값을_입력시_예외처리() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputUtil.checkIsDigit('a',Constant.ISDIGIT_EXCEPTION.getMessage());
        });
    }

    @Test()
    void 중복된_숫자입력_예외처리() {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 1, 1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputUtil.checkDuplicationNumber(numbers, 1);
        });
    }

    @Test()
    void 불가능한_숫자입력_예외처리() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputUtil.checkValidNumber(0,Constant.MIN_NUM.getNumber(),Constant.MAX_NUM.getNumber()
                    ,Constant.VALID_NUMBER_EXCEPTION.getMessage());
        });
    }

    @Test()
    void 글자수_길이초과_예외처리() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputUtil.checkLength("1234",Constant.COMPUTER_NUMBER_LENGTH.getNumber(),
                    Constant.NUMBER_LENGTH_EXCEPTION.getMessage());
        });
    }
}
