package baseball.mvc.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.helper.util.GameStatusTestUtils;
import baseball.mvc.structure.enums.GameCommand;
import baseball.util.GameStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class GameCommandTest {

    @Nested
    @DisplayName("commandGameStatus 메소드는")
    class CommandGameStatusMethodTest {

        private final static String WRONG_INPUT = "잘못된 입력입니다.";

        @ParameterizedTest
        @CsvSource(
                value = {
                    "1:START",
                    "2:EXIT"
                },
                delimiter = ':'
        )
        @DisplayName("만약 정상적인 사용자 입력이 주어졌다면 그에 맞게 변경할 GameStatus를 반환한다.")
        void success_test(String playerInput, String gameStatusName) {
            GameStatus expectGameStatus = GameStatusTestUtils.findGameStatusByName(gameStatusName);

            GameStatus resultGameStatus = GameCommand.commandGameStatus(playerInput);

            assertThat(resultGameStatus).isSameAs(expectGameStatus);
        }

        @ParameterizedTest
        @ValueSource(
                strings = {
                    "a",
                    "+",
                    "0",
                    "3",
                    "@"
                }
        )
        @DisplayName("만약 정상적이지 않은 사용자 입력이 주어졌다면 IllegalArgumentException 예외가 발생한다.")
        void wrong_input_exception_test(String playerWrongInput) {
            assertThatThrownBy(() -> GameCommand.commandGameStatus(playerWrongInput))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(WRONG_INPUT);
        }
    }
}