package baseball.referee;

import baseball.baesball.Baseball;
import baseball.hint.HintGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static baseball.referee.JudgeType.GAME_LOSE;
import static baseball.referee.JudgeType.GAME_WIN;
import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {
    private final Referee referee = new Referee(new HintGenerator(), new Megaphone());

    @ParameterizedTest(name = "[{index}] computer = {0}, player = {1}, judgeType = {2}")
    @MethodSource("whenJudgePlayersThenSuccessDummy")
    @DisplayName("심판 플레이어 승리 판별 성공 테스트")
    void whenJudgePlayersThenSuccessTest(List<Integer> computerBalls, List<Integer> playerBalls, JudgeType judgeType) {
        Baseball computer = new Baseball(computerBalls);
        Baseball player = new Baseball(playerBalls);
        JudgeType findJudgeType = referee.judgeFrom(computer, player);
        assertThat(findJudgeType).isEqualTo(judgeType);
    }

    static Stream<Arguments> whenJudgePlayersThenSuccessDummy() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 3), List.of(1, 2, 3), GAME_WIN),
                Arguments.arguments(List.of(6, 2, 1), List.of(6, 2, 1), GAME_WIN),
                Arguments.arguments(List.of(1, 5, 2), List.of(1, 5, 2), GAME_WIN),
                Arguments.arguments(List.of(5, 8, 4), List.of(5, 8, 4), GAME_WIN),
                Arguments.arguments(List.of(7, 8, 4), List.of(7, 8, 4), GAME_WIN),
                Arguments.arguments(List.of(9, 5, 2), List.of(9, 5, 2), GAME_WIN),
                Arguments.arguments(List.of(5, 2, 1), List.of(5, 2, 1), GAME_WIN),
                Arguments.arguments(List.of(2, 5, 6), List.of(2, 5, 6), GAME_WIN),
                Arguments.arguments(List.of(4, 8, 7), List.of(1, 8, 4), GAME_LOSE),
                Arguments.arguments(List.of(7, 4, 3), List.of(7, 1, 3), GAME_LOSE),
                Arguments.arguments(List.of(6, 2, 3), List.of(1, 2, 3), GAME_LOSE),
                Arguments.arguments(List.of(8, 7, 1), List.of(8, 3, 7), GAME_LOSE),
                Arguments.arguments(List.of(4, 7, 3), List.of(1, 5, 3), GAME_LOSE),
                Arguments.arguments(List.of(6, 2, 3), List.of(2, 1, 3), GAME_LOSE),
                Arguments.arguments(List.of(2, 5, 3), List.of(1, 6, 3), GAME_LOSE),
                Arguments.arguments(List.of(7, 4, 1), List.of(9, 3, 7), GAME_LOSE)
        );
    }
}