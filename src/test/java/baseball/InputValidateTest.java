package baseball;

import baseball.service.GameService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidateTest {

    GameService gameService = new GameService();

    @Test
    @DisplayName("입력한 숫자는 범위가 1~9이여야함")
    void validateUserInputRange() {
        assertThatThrownBy(() -> gameService.validateUserInput("012")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> gameService.validateUserInput("1234")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> gameService.validateUserInput("133")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력한 숫자는 3개여야함")
    void validateUserInputCount() {
        assertThatThrownBy(() -> gameService.validateUserInput("12")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> gameService.validateUserInput("1234")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> gameService.validateUserInput("1")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력한 숫자는 중복이 없어야함")
    void validateUserInputDuplicated() {
        assertThatThrownBy(() -> gameService.validateUserInput("111")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> gameService.validateUserInput("133")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("게임 종료, 재시작 입력은 1또는 2만 입력해야함")
    void gameRestartQuestionValidate() {
        assertThatThrownBy(() -> gameService.isRetryGame("3")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> gameService.isRetryGame("에러")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> gameService.isRetryGame("0")).isInstanceOf(IllegalArgumentException.class);
    }
}
