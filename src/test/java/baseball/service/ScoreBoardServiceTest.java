package baseball.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class ScoreBoardServiceTest {

    static ScoreBoardService scoreBoardService = new ScoreBoardService();

    @Nested
    @DisplayName("setScoreBoard 테스트")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class SetScoreBoardTest {
        Stream<Arguments> Data() {
            return Stream.of(
                    Arguments.of(List.of(1, 2, 3), List.of(1, 2, 3), 0, 3),
                    Arguments.of(List.of(1, 2, 3), List.of(1, 2, 4), 0, 2),
                    Arguments.of(List.of(1, 2, 3), List.of(1, 4, 5), 0, 1),
                    Arguments.of(List.of(1, 2, 3), List.of(1, 4, 2), 1, 1),
                    Arguments.of(List.of(1, 2, 3), List.of(1, 3, 2), 2, 1),
                    Arguments.of(List.of(1, 2, 3), List.of(3, 4, 5), 1, 0),
                    Arguments.of(List.of(1, 2, 3), List.of(2, 3, 4), 2, 0),
                    Arguments.of(List.of(1, 2, 3), List.of(2, 3, 1), 3, 0),
                    Arguments.of(List.of(1, 2, 3), List.of(4, 5, 6), 0, 0)
            );
        }

        @ParameterizedTest
        @MethodSource("Data")
        void case1(List<Integer> computerNumbers, List<Integer> playerNumbers, int ball, int strike) {
            scoreBoardService.setScoreBoard(computerNumbers, playerNumbers);
            Assertions.assertThat(scoreBoardService.getScoreBoard().getBall()).isEqualTo(ball);
            Assertions.assertThat(scoreBoardService.getScoreBoard().getStrike()).isEqualTo(strike);
        }
    }
}
