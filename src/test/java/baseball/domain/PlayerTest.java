package baseball.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {

    @Test
    void 입력값이_3개의_숫자가아니면_예외발생() {
        assertThatThrownBy(() -> new Player(List.of(1, 2, 3, 4)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값은 3개의 숫자여야 합니다.");
    }

    @MethodSource("createNumberExTestCase")
    @ParameterizedTest
    void 입력값이_같은수가_하나라도_있으면_예외발생(int a, int b, int c) {
        assertThatThrownBy(() -> new Player(List.of(a, b, c)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값은 같은 수가 하나라도 있으면 안됩니다.");
    }

    private static List<Arguments> createNumberExTestCase() {
        return List.of(
                Arguments.of(1, 2, 2),
                Arguments.of(2, 1, 2),
                Arguments.of(2, 2, 1)
        );
    }

    @Test
    void 두명의_플레이어가_플레이_3스트라이크() {
        Player player = new Player(List.of(1, 2, 3));
        Player otherPlayer = new Player(List.of(1, 2, 3));
        GameResult gameResult = player.playGame(otherPlayer);

        assertThat(gameResult).isEqualTo(new GameResult(3, 0));
    }

    @Test
    void 두명의_플레이어가_플레이_3볼() {
        Player player = new Player(List.of(1, 2, 3));
        Player otherPlayer = new Player(List.of(3, 1, 2));
        GameResult gameResult = player.playGame(otherPlayer);

        assertThat(gameResult).isEqualTo(new GameResult(0, 3));
    }

    @Test
    void 두명의_플레이어가_플레이_낫싱() {
        Player player = new Player(List.of(1, 2, 3));
        Player otherPlayer = new Player(List.of(4, 5, 6));
        GameResult gameResult = player.playGame(otherPlayer);

        assertThat(gameResult).isEqualTo(new GameResult(0, 0));
    }

    @Test
    void 두명의_플레이어가_플레이_1스트라이크_1볼() {
        Player player = new Player(List.of(1, 2, 3));
        Player otherPlayer = new Player(List.of(1, 3, 4));
        GameResult gameResult = player.playGame(otherPlayer);

        assertThat(gameResult).isEqualTo(new GameResult(1, 1));
    }

    @Test
    void 두명의_플레이어가_플레이_2스트라이크_0볼() {
        Player player = new Player(List.of(1, 2, 3));
        Player otherPlayer = new Player(List.of(1, 2, 4));
        GameResult gameResult = player.playGame(otherPlayer);

        assertThat(gameResult).isEqualTo(new GameResult(2, 0));
    }

    @Test
    void 두명의_플레이어가_플레이_0스트라이크_2볼() {
        Player player = new Player(List.of(1, 2, 3));
        Player otherPlayer = new Player(List.of(2, 1, 4));
        GameResult gameResult = player.playGame(otherPlayer);

        assertThat(gameResult).isEqualTo(new GameResult(0, 2));
    }

    @Test
    void 두명의_플레이어가_플레이_1스트라이크_0볼() {
        Player player = new Player(List.of(1, 2, 3));
        Player otherPlayer = new Player(List.of(1, 4, 5));
        GameResult gameResult = player.playGame(otherPlayer);

        assertThat(gameResult).isEqualTo(new GameResult(1, 0));
    }

    @Test
    void 두명의_플레이어가_플레이_0스트라이크_1볼() {
        Player player = new Player(List.of(1, 2, 3));
        Player otherPlayer = new Player(List.of(4, 5, 1));
        GameResult gameResult = player.playGame(otherPlayer);

        assertThat(gameResult).isEqualTo(new GameResult(0, 1));
    }

    @Test
    void 플레이어의_볼3개를_바꾸고_게임실행() {
        Player player = new Player(List.of(1, 2, 3));
        Player otherPlayer = new Player(List.of(1, 2, 3));

        player.changeBalls(List.of(4, 5, 6));
        GameResult gameResult = player.playGame(otherPlayer);

        assertThat(gameResult).isEqualTo(new GameResult(0, 0));
    }
}
