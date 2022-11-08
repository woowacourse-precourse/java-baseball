package baseball.view;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.Hint;
import baseball.domain.Hints;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class OutputTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @DisplayName("게임 시작 문구 출력")
    @Test
    void start() {
        Output.start();

        assertThat(outContent.toString()).contains("숫자 야구 게임을 시작합니다.");
    }

    private static Stream<Arguments> provideForResult() {
        return Stream.of(
                Arguments.of(new Hints(List.of(Hint.STRIKE, Hint.BALL)), "1볼 1스트라이크"),
                Arguments.of(new Hints(List.of()), "낫싱"),
                Arguments.of(new Hints(List.of(Hint.STRIKE, Hint.STRIKE, Hint.STRIKE)),
                        "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        );
    }

    @ParameterizedTest(name = "결과를 볼, 스트라이크 개수로 표시한다.")
    @MethodSource("provideForResult")
    void result(Hints hints, String expected) {
        Output.result(hints);

        assertThat(outContent.toString()).contains(expected);
    }
}
