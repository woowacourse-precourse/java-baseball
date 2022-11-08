package baseball;

import baseball.controller.HandleException;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExceptionTest extends NsTest {
    @DisplayName("예외 처리 테스트1 - 사용자가 1~9 이외의 숫자를 입력했을 경우")
    @Test
    void userInputExceptionTest() {
        // given
        String userInput = "1:2";
        HandleException handleException = new HandleException();

        // when, then
        assertThatThrownBy(() -> handleException.handleUserInputNumberRangeException(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 값을 입력하였습니다. 게임을 종료합니다.");
    }

    @DisplayName("예외 처리 테스트2 - 사용자가 3개의 숫자를 입력하지 않았을 경우")
    @Test
    void userInputSizeExceptionTest() {
        //given
        String userInput1 = "12";
        String userInput2 = "1234";
        HandleException handleException = new HandleException();

        // when, then
        assertThatThrownBy(() -> handleException.handleUserInputSizeException(userInput1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3개의 숫자를 입력하지 않았습니다. 게임을 종료합니다.");

        assertThatThrownBy(() -> handleException.handleUserInputSizeException(userInput2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3개의 숫자를 입력하지 않았습니다. 게임을 종료합니다.");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
