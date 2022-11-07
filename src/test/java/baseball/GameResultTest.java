package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

public class GameResultTest {
    @Test
    @DisplayName("사용자가 이겼다고 판단하는지 확인한다")
    void isUserWinTestO() {
        GameResult gameResult = new GameResult();
        gameResult.setGameResult(3, 0);
        Assertions.assertThat(gameResult.isUserWin()).isEqualTo(true);
    }

    @Test
    @DisplayName("사용자가 졌다고 판단하는지 확인한다")
    void isUserWinTestX() {
        GameResult gameResult = new GameResult();
        gameResult.setGameResult(2, 1);
        Assertions.assertThat(gameResult.isUserWin()).isEqualTo(false);
    }

    @Test
    @DisplayName("낫싱 상태를 판단하는지 확인한다")
    void isNothingO() {
        GameResult gameResult = new GameResult();
        gameResult.setGameResult(0, 0);
        Assertions.assertThat(gameResult.isNothing()).isEqualTo(true);
    }

    @Test
    @DisplayName("낫싱 상태가 아님을 판단하는지 확인한다")
    void isNothingX() {
        GameResult gameResult = new GameResult();
        gameResult.setGameResult(1, 0);
        Assertions.assertThat(gameResult.isNothing()).isEqualTo(false);
    }

    @ParameterizedTest
    @MethodSource("providePrintTestcase")
    @DisplayName("출력 결과를 테스트한다")
    void printResult(GameResult gameResult, String result) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        gameResult.printResult();
        Assertions.assertThat(output.toString()).isEqualTo(result);

        System.setOut(System.out);
        output.reset();
    }

    private static Stream<Arguments> providePrintTestcase() {
        return Stream.of(
                Arguments.of(new GameResult(0, 0), "낫싱\n"),
                Arguments.of(new GameResult(4, 0), "낫싱\n"),
                Arguments.of(new GameResult(3, 0), "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"),
                Arguments.of(new GameResult(2, 1), "1볼 2스트라이크\n"));
    }
}
