package baseball.model;

import baseball.vo.Player;
import baseball.vo.ScoreBoard;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class RefereeTest {

    static Stream<Arguments> judgeTest() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3), new Player(Arrays.asList(1, 2, 3)), Arrays.asList(0, 3)),
                Arguments.of(Arrays.asList(1, 2, 3), new Player(Arrays.asList(1, 2, 4)), Arrays.asList(0, 2)),
                Arguments.of(Arrays.asList(1, 2, 3), new Player(Arrays.asList(1, 5, 6)), Arrays.asList(0, 1)),
                Arguments.of(Arrays.asList(1, 2, 3), new Player(Arrays.asList(8, 5, 6)), Arrays.asList(0, 0))
        );
    }

    @ParameterizedTest
    @MethodSource(value = "judgeTest")
    @DisplayName("볼, 스트라이크 판정")
    public void giveScore(List<Integer> computerSelectedNumber, Player player, List<Integer> expected) {
        Referee referee = new Referee(computerSelectedNumber);
        ScoreBoard scoreBoard = referee.giveScore(player);
        Assertions.assertThat(scoreBoard.getBall()).isEqualTo(expected.get(0));
        Assertions.assertThat(scoreBoard.getStrike()).isEqualTo(expected.get(1));
    }
}
