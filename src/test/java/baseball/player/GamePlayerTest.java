package baseball.player;

import baseball.baesball.Baseball;
import baseball.baesball.PlayerBaseballGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Stream;

import static baseball.exception.ConsoleException.BASEBALL_INPUT_EXCEPTION;
import static baseball.game.GameRule.BASEBALL_MAX_SIZE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class GamePlayerTest {
    private final GamePlayer gamePlayer = new GamePlayer();

    @ParameterizedTest(name = "[{index}] balls = {0}")
    @MethodSource("whenPlayGameThenSuccessDummy")
    @DisplayName("게임 플레이어 야구공 생성 성공 테스트")
    void whenPlayGameThenSuccessTest(String inputBall) {
        System.setIn(new ByteArrayInputStream(inputBall.getBytes(StandardCharsets.UTF_8)));
        Baseball baseball = gamePlayer.playGame(new PlayerBaseballGenerator());
        List<Integer> balls = baseball.getBaseballs();
        assertThat(balls).hasSize(BASEBALL_MAX_SIZE.getRule());
    }

    @ParameterizedTest(name = "[{index}] balls = {0}")
    @MethodSource("whenPlayGameThenExceptionDummy")
    @DisplayName("게임 플레이어 야구공 생성 실패 예외처리 테스트")
    void whenPlayGameThenSuccessDummy(String inputBall) {
        System.setIn(new ByteArrayInputStream(inputBall.getBytes(StandardCharsets.UTF_8)));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> gamePlayer.playGame(new PlayerBaseballGenerator()))
                .withMessageMatching(BASEBALL_INPUT_EXCEPTION.getMessage());
    }

    static Stream<Arguments> whenPlayGameThenSuccessDummy() {
        return Stream.of(
                Arguments.arguments("123"),
                Arguments.arguments("234"),
                Arguments.arguments("158"),
                Arguments.arguments("731"),
                Arguments.arguments("482"),
                Arguments.arguments("482"),
                Arguments.arguments("173"),
                Arguments.arguments("823"),
                Arguments.arguments("628"),
                Arguments.arguments("437"),
                Arguments.arguments("178"),
                Arguments.arguments("538")
        );
    }

    static Stream<Arguments> whenPlayGameThenExceptionDummy() {
        return Stream.of(
                Arguments.arguments("0"),
                Arguments.arguments("1"),
                Arguments.arguments("2"),
                Arguments.arguments("3"),
                Arguments.arguments("4"),
                Arguments.arguments("28"),
                Arguments.arguments("38"),
                Arguments.arguments("23"),
                Arguments.arguments("18"),
                Arguments.arguments("2342"),
                Arguments.arguments("1548"),
                Arguments.arguments("7311"),
                Arguments.arguments("4842"),
                Arguments.arguments("48392"),
                Arguments.arguments("17357"),
                Arguments.arguments("82731"),
                Arguments.arguments("6281235"),
                Arguments.arguments("43234527"),
                Arguments.arguments("178245543542"),
                Arguments.arguments("53634623456358")
        );
    }
}