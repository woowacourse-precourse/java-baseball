package baseball.game;

import baseball.console.ConsoleInput;
import baseball.console.ConsoleOutput;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

import static baseball.exception.ConsoleException.ANOTHER_GAME_INPUT_EXCEPTION;
import static baseball.game.GameStatus.GAME_END;
import static baseball.game.GameStatus.GAME_RESTART;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class GameOrganizerTest {
    private static final String RESTART_CONSOLE = "1";
    private static final String END_CONSOLE = "2";
    private final GameOrganizer gameOrganizer = new GameOrganizer(new ConsoleInput(), new ConsoleOutput());

    @RepeatedTest(100)
    @DisplayName("콘솔 입력 게임 재시작 상태 성공 테스트")
    void whenInputGameRestartThenSuccessTest() {
        System.setIn(new ByteArrayInputStream(RESTART_CONSOLE.getBytes(StandardCharsets.UTF_8)));
        GameStatus gameStatus = gameOrganizer.askAnotherGame();
        assertThat(gameStatus).isEqualTo(GAME_RESTART);
    }

    @RepeatedTest(100)
    @DisplayName("콘솔 입력 게임 종료 상태 성공 테스트")
    void whenInputGameEndThenSuccessTest() {
        System.setIn(new ByteArrayInputStream(END_CONSOLE.getBytes(StandardCharsets.UTF_8)));
        GameStatus gameStatus = gameOrganizer.askAnotherGame();
        assertThat(gameStatus).isEqualTo(GAME_END);
    }

    @ParameterizedTest(name = "[{index}] input = {0}")
    @MethodSource("whenInputWrongThenExceptionDummy")
    @DisplayName("잘못된 콘솔 입력 실패 예외처리 테스트")
    void whenInputWrongThenExceptionTest(String inputConsole) {
        System.setIn(new ByteArrayInputStream(inputConsole.getBytes(StandardCharsets.UTF_8)));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(gameOrganizer::askAnotherGame)
                .withMessageMatching(ANOTHER_GAME_INPUT_EXCEPTION.getMessage());
    }

    static Stream<Arguments> whenInputWrongThenExceptionDummy() {
        return Stream.of(
                Arguments.arguments("3"),
                Arguments.arguments("4"),
                Arguments.arguments("5"),
                Arguments.arguments("5"),
                Arguments.arguments("11"),
                Arguments.arguments("12"),
                Arguments.arguments("22"),
                Arguments.arguments("111"),
                Arguments.arguments("222")
        );
    }

}