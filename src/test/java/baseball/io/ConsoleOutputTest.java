package baseball.io;

import baseball.model.BallStatus;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.NullSource;

public class ConsoleOutputTest {
    private static final ConsoleOutput output = new ConsoleOutput();
    private static ByteArrayOutputStream outputMessage;

    static class PrintScoreValidSourceProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of(new BallStatus(1, 0), "1볼\n"),
                    Arguments.of(new BallStatus(1, 1), "1볼 1스트라이크\n"),
                    Arguments.of(new BallStatus(0, 1), "1스트라이크\n"),
                    Arguments.of(new BallStatus(0, 0), "낫싱\n")
            );
        }
    }

    @BeforeEach
    void setUp() {
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @AfterEach
    void restore() {
        System.setOut(System.out);
    }

    @Test
    @DisplayName("어플리케이션 시작 문구 테스트")
    void startTextWhenRunApplication() {
        output.printStartText();

        Assertions.assertThat(outputMessage.toString()).isEqualTo("숫자 야구 게임을 시작합니다.\n");
    }

    @Nested
    @DisplayName("printScore 메서드눈")
    class DescribePrintScore {
        @ParameterizedTest
        @NullSource
        @DisplayName("인자로 null을 받으면 IllegalArgumentException을 반환한다.")
        void receiveNullThrowIllegalArgumentException(BallStatus ballStatus) {
            Assertions.assertThatThrownBy(() -> output.printScore(ballStatus))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ArgumentsSource(PrintScoreValidSourceProvider.class)
        @DisplayName("인자로 받은 ballCount의 볼과 스트라이크 정보를 출력한다.")
        void printBallCount(BallStatus ballStatus, String expected) {
            output.printScore(ballStatus);

            Assertions.assertThat(outputMessage.toString()).isEqualTo(expected);
        }
    }
}
