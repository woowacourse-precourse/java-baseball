package baseball.exception;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("예외 처리 테스트")
public class GameExceptionHandlerTest {

    @Test
    @DisplayName("공통 예외 - 숫자가 아닌 경우")
    void handleNotNumberExceptionTest() {
        String alphabetInput = "abc";
        String markInput = "!@#";

        assertThatThrownBy(() -> {
            GameExceptionHandler.handleNotNumberException(alphabetInput);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            GameExceptionHandler.handleNotNumberException(markInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("공통 예외 - 입력이 비어있는 경우")
    void handleEmptyExceptionTest() {
        String emptyString = "";

        assertThatThrownBy(() -> {
            GameExceptionHandler.handleEmptyException(emptyString);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("게임 진행 중 예외 - 3자리 숫자가 아닌 경우")
    void handleNotThreeNumbersExceptionTest() {
        String lessThanThreeNumbers = "12";
        String moreThanThreeNumbers = "1234";

        assertThatThrownBy(() -> {
            GameExceptionHandler.handleNotThreeNumbersException(lessThanThreeNumbers);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            GameExceptionHandler.handleNotThreeNumbersException(moreThanThreeNumbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("게임 진행 중 예외 - 0이 포함되는 경우")
    void handleIncludeZeroExceptionTest() {
        String includeZeroNumbers = "012";

        assertThatThrownBy(() -> {
            GameExceptionHandler.handleIncludeZeroException(includeZeroNumbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("게임 종료 후 예외 - 1 또는 2가 아닌 경우")
    void handleRestartInputExceptionTest() {
        String notOneOrTwoNumber = "3";

        assertThatThrownBy(() -> {
            GameExceptionHandler.handleRestartInputException(notOneOrTwoNumber);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
