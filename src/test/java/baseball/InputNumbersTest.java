package baseball;

import org.junit.jupiter.api.Test;

import static constant.ErrorMessage.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class InputNumbersTest {
//    @Test
//    void 입력값_테스트_정상입력() {
//        String userInput = "123";
//        boolean result = InputNumbers.validInputNumber(userInput);
//        assertTrue(result);
//    }
//
//    @Test
//    void 입력값_테스트_비정상입력_길이초과() {
//        String userInput = "1234";
//        assertThatThrownBy(() -> InputNumbers.validInputNumber(userInput))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining(INVALID_INPUT_RADIX);
//
//    }
//
//    @Test
//    void 입력값_테스트_비정상입력_길이미달() {
//        String userInput = "1";
//        assertThatThrownBy(() -> InputNumbers.validInputNumber(userInput))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining(INVALID_INPUT_RADIX);
//    }
//
//    @Test
//    void 입력값_테스트_비정상입력_문자포함() {
//        String userInput = "12c";
//        assertThatThrownBy(() -> InputNumbers.validInputNumber(userInput))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining(INVALID_INPUT_VALUE);
//    }
//
//    @Test
//    void 입력값_테스트_비정상입력_같은숫자포함() {
//        String userInput = "224";
//        assertThatThrownBy(() -> InputNumbers.validInputNumber(userInput))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining(DUPLICATE_INPUT_VALUE);
//    }
//
//    @Test
//    void 입력값_테스트_비정상입력_범위벗어난_숫자() {
//        String userInput = "102";
//        assertThatThrownBy(() -> InputNumbers.validInputNumber(userInput))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining(INVALID_INPUT_VALUE);
//    }
}