package baseball.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CommandTest {

    @DisplayName("게임 종료 후 올바른 재시작 커맨드를 입력했을 때 정상적으로 작동되는지 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    void checkCommand_For_Restart(String commandString) {
        assertThatNoException()
                .isThrownBy(() -> Command.of(commandString));
    }

    @DisplayName("사용자가 잘못된 재시작 커맨드를 입력했을 때 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"a", " ", "5", "!"})
    void checkCommand_InvalidCommandString_IllegalArgumentExceptionThrown(String commandString) {
        assertThatThrownBy(() -> Command.of(commandString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("올바르지 않은 형식의 재시작 커맨드를 입력하셨습니다.");
    }






}
