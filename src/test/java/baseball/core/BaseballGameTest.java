package baseball.core;

import baseball.type.GameStatus;
import baseball.type.SuccessCondition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class BaseballGameTest {

    BaseballGame baseballGame;
    BaseballNumber baseballNumber;
    GameStatusOperator gameStatusOperator;

    @BeforeEach
    void initBaseballGame() {
        baseballNumber = new BaseballNumber("123");
        gameStatusOperator = GameInitializer.initGameStatusOperator();
        baseballGame = new BaseballGame(baseballNumber, gameStatusOperator);
    }

    @DisplayName("게임을 시작하면 게임 상태가 ONGOING으로 설정된다.")
    @Test
    void startGame() {
        baseballGame.startGame();
        GameStatus currentStatus = baseballGame.getCurrentStatus();
        assertThat(currentStatus).isEqualTo(GameStatus.ONGOING);
    }

    @DisplayName("플레이어가 입력한 숫자에 따라 볼의 개수, 스트라이크의 개수를 업데이트한다.")
    @ParameterizedTest
    @CsvSource(value = {"345:1:0", "234:2:0", "425:0:1", "213:2:1", "123:0:3"}, delimiter = ':')
    void executeGameRound(String inputNumber, int numberOfBall, int numberOfStrike) {
        Map<String, Integer> resultOfGame = baseballGame.executeGameRound(inputNumber);
        assertThat(resultOfGame.get("ball")).isEqualTo(numberOfBall);
        assertThat(resultOfGame.get("strike")).isEqualTo(numberOfStrike);
    }

    @DisplayName("플레이어가 입력한 숫자에 따라 정답 숫자를 맞춘 여부를 반환한다.")
    @ParameterizedTest
    @MethodSource("provideInputNumberAndSuccessCondition")
    void checkSuccessOrFail(String inputNumber, SuccessCondition successCondition) {
        baseballGame.executeGameRound(inputNumber);
        assertThat(baseballGame.checkSuccessOrFail()).isEqualTo(successCondition);
    }

    @DisplayName("플레이어가 1을 입력하면 게임 재시작, 2를 입력하면 게임 종료를 수행한다.")
    @ParameterizedTest
    @MethodSource("provideCommandAndStatus")
    void executeGameByCommand(String gameCommand, GameStatus gameStatus) {
        baseballGame.executeGameByCommand(gameCommand);
        assertThat(gameStatusOperator.getGameStatus()).isEqualTo(gameStatus);
    }

    private static Stream<Arguments> provideInputNumberAndSuccessCondition() {
        return Stream.of(
                Arguments.of("345", SuccessCondition.FAIL),
                Arguments.of("234", SuccessCondition.FAIL),
                Arguments.of("425", SuccessCondition.FAIL),
                Arguments.of("213", SuccessCondition.FAIL),
                Arguments.of("123", SuccessCondition.SUCCESS)
        );
    }

    private static Stream<Arguments> provideCommandAndStatus() {
        return Stream.of(
                Arguments.of("1", GameStatus.START),
                Arguments.of("2", GameStatus.QUIT)
        );
    }


}