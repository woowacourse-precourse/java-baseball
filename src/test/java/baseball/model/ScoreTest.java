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
    @MethodSource("makeResultMessageInit")
    void makeResultMessage(Score score, String message) {
        assertThat(score.makeResultMessage("볼", "스트라이크", "낫싱"))
                .isEqualTo(message);
    }

    private static Stream<Arguments> makeResultMessageInit() {
        return Stream.of(
                Arguments.of(new Score(3, 0), "3스트라이크"),
                Arguments.of(new Score(2, 1), "1볼 2스트라이크"),
                Arguments.of(new Score(1, 2), "2볼 1스트라이크"),
                Arguments.of(new Score(1, 1), "1볼 1스트라이크"),
                Arguments.of(new Score(0, 3), "3볼"),
                Arguments.of(new Score(0, 0), "낫싱")
        );
    }
}