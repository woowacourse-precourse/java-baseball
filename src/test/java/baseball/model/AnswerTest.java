package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.vo.Score;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class AnswerTest {

    private static Stream<Arguments> provideUserInput() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), 3, 0),
                Arguments.of(List.of(1, 2, 4), 2, 0),
                Arguments.of(List.of(1, 3, 2), 1, 2),
                Arguments.of(List.of(1, 3, 4), 1, 1),
                Arguments.of(List.of(1, 4, 5), 1, 0),
                Arguments.of(List.of(2, 3, 1), 0, 3),
                Arguments.of(List.of(2, 3, 4), 0, 2),
                Arguments.of(List.of(4, 3, 5), 0, 1),
                Arguments.of(List.of(4, 5, 6), 0, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideUserInput")
    public void answerTest(List<Integer> userInput, int strike, int ball) {
        Answer answer = new Answer(List.of(1, 2, 3));

        Score score = answer.compare(userInput);

        assertThat(score.getStrike())
                .isEqualTo(strike);
        assertThat(score.getBall())
                .isEqualTo(ball);
    }

}
