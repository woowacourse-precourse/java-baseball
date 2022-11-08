package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Score 클래스를 검증한다.")
class ScoreTest {

    @DisplayName("결과 메시지 출력을 검증한다.")
    @ParameterizedTest
    @MethodSource("makeResultMessageData")
    void makeResultMessage(Score score, String message) {
        assertThat(score.makeResultMessage("볼", "스트라이크", "낫싱"))
                .isEqualTo(message);
    }

    private static Stream<Arguments> makeResultMessageData() {
        return Stream.of(
                Arguments.of(new Score(3, 0), "3스트라이크"),
                Arguments.of(new Score(2, 1), "1볼 2스트라이크"),
                Arguments.of(new Score(1, 2), "2볼 1스트라이크"),
                Arguments.of(new Score(1, 1), "1볼 1스트라이크"),
                Arguments.of(new Score(0, 3), "3볼"),
                Arguments.of(new Score(0, 0), "낫싱")
        );
    }

    @DisplayName("게임 계속할지 여부를 확인하는 메서드를 검증한다.")
    @ParameterizedTest
    @MethodSource("canContinueTestData")
    void canContinue(Score score, boolean result) {
        assertThat(score.canContinue()).isEqualTo(result);
    }

    private static Stream<Arguments> canContinueTestData() {
        return Stream.of(
                Arguments.of(new Score(0, 0), true),
                Arguments.of(new Score(1, 0), true),
                Arguments.of(new Score(2, 0), true),
                Arguments.of(new Score(2, 1), true),
                Arguments.of(new Score(1, 1), true),
                Arguments.of(new Score(0, 1), true),
                Arguments.of(new Score(0, 2), true),
                Arguments.of(new Score(0, 3), true),
                Arguments.of(new Score(3, 0), false)
        );
    }
}