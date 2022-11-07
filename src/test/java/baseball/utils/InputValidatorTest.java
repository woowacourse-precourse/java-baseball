package baseball.utils;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    @DisplayName("입력 오류 3자리 초과")
    void 사용자_입력_오류1() {
        String userInput = "1234";
        assertThrows(IllegalArgumentException.class,
                () -> InputValidator.checkUserBallInput(userInput)
        );
    }

    @Test
    @DisplayName("입력 오류 3자리 미만 : 1자리")
    void 사용자_입력_오류2_1() {
        String userInput = "1";
        assertThrows(IllegalArgumentException.class,
                () -> InputValidator.checkUserBallInput(userInput)
        );
    }

    @Test
    @DisplayName("입력 오류 3자리 미만 : 2자리")
    void 사용자_입력_오류2_2() {
        String userInput = "12";
        assertThrows(IllegalArgumentException.class,
                () -> InputValidator.checkUserBallInput(userInput)
        );
    }

    @Test
    @DisplayName("입력 오류 3자리 미만 : 3자리")
    void 사용자_입력_오류2_3() {
        String userInput = "";
        assertThrows(IllegalArgumentException.class,
                () -> InputValidator.checkUserBallInput(userInput)
        );
    }

    @Test
    @DisplayName("입력 오류 숫자 이외 문자 입력 : 특수문자_1")
    void 사용자_입력_오류3_1() {
        String userInput = "3.1";
        assertThrows(IllegalArgumentException.class,
                () -> InputValidator.checkUserBallInput(userInput)
        );
    }

    @Test
    @DisplayName("입력 오류 숫자 이외 문자 입력 : 특수문자_2")
    void 사용자_입력_오류3_2() {
        String userInput = "31)";
        assertThrows(IllegalArgumentException.class,
                () -> InputValidator.checkUserBallInput(userInput)
        );
    }

    @Test
    @DisplayName("입력 오류 숫자 이외 문자 입력 : 공백_1")
    void 사용자_입력_오류4_1() {
        String userInput = "3 1";
        assertThrows(IllegalArgumentException.class,
                () -> InputValidator.checkUserBallInput(userInput)
        );
    }

    @Test
    @DisplayName("입력 오류 숫자 이외 문자 입력 : 공백_2")
    void 사용자_입력_오류4_2() {
        String userInput = " 57";
        assertThrows(IllegalArgumentException.class,
                () -> InputValidator.checkUserBallInput(userInput)
        );
    }

    @Test
    @DisplayName("중복 숫자 입력_1")
    void 사용자_입력_오류5_1() {
        String userInput = "557";
        assertThrows(IllegalArgumentException.class,
                () -> InputValidator.checkUserBallInput(userInput)
        );
    }

    @Test
    @DisplayName("중복 숫자 입력_2")
    void 사용자_입력_오류5_2() {
        String userInput = "888";
        assertThrows(IllegalArgumentException.class,
                () -> InputValidator.checkUserBallInput(userInput)
        );
    }

    @Test
    @DisplayName("재시작 숫자 오류")
    void 사용자_입력_오류6() {
        String userInput = "3";
        assertThrows(IllegalArgumentException.class,
                () -> InputValidator.checkRestartInput(userInput)
        );
    }

    @Test
    @DisplayName("재시작 숫자 오류2")
    void 사용자_입력_오류7() {
        String userInput = ".";
        assertThrows(IllegalArgumentException.class,
                () -> InputValidator.checkRestartInput(userInput)
        );
    }

    @Test
    @DisplayName("재시작 숫자 오류3")
    void 사용자_입력_오류8() {
        String userInput = " ";
        assertThrows(IllegalArgumentException.class,
                () -> InputValidator.checkRestartInput(userInput)
        );
    }


}