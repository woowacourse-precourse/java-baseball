package baseball.console;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

import static baseball.exception.ConsoleException.BASEBALL_INPUT_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ConsoleInputTest {
    private final ConsoleInput consoleInput = new ConsoleInput();

    @ParameterizedTest(name = "[{index}] balls = {0}")
    @MethodSource("whenInputBaseballThenSuccessDummy")
    @DisplayName("콘솔 입력 야구공 생성 성공 테스트")
    void whenInputBaseballThenSuccessTest(String balls) {
        System.setIn(new ByteArrayInputStream(balls.getBytes(StandardCharsets.UTF_8)));
        String baseball = consoleInput.readBaseBall();
        assertThat(balls).isEqualTo(baseball);
    }

    @ParameterizedTest(name = "[{index}] balls = {0}")
    @MethodSource("whenInputBaseballWrongThenExceptionDummy")
    @DisplayName("콘솔 입력 야구공 생성 실패 예외처리 테스트")
    void whenInputBaseballWrongThenExceptionTest(String balls) {
        System.setIn(new ByteArrayInputStream(balls.getBytes(StandardCharsets.UTF_8)));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(consoleInput::readBaseBall)
                .withMessageMatching(BASEBALL_INPUT_EXCEPTION.getMessage());
    }

    static Stream<Arguments> whenInputBaseballThenSuccessDummy() {
        return Stream.of(
                Arguments.arguments("123"),
                Arguments.arguments("234"),
                Arguments.arguments("158"),
                Arguments.arguments("731"),
                Arguments.arguments("482"),
                Arguments.arguments("482"),
                Arguments.arguments("173"),
                Arguments.arguments("823"),
                Arguments.arguments("628"),
                Arguments.arguments("437"),
                Arguments.arguments("178"),
                Arguments.arguments("538")
        );
    }

    static Stream<Arguments> whenInputBaseballWrongThenExceptionDummy() {
        return Stream.of(
                Arguments.arguments("0"),
                Arguments.arguments("1"),
                Arguments.arguments("2"),
                Arguments.arguments("00"),
                Arguments.arguments("12"),
                Arguments.arguments("23"),
                Arguments.arguments("000"),
                Arguments.arguments("001"),
                Arguments.arguments("002"),
                Arguments.arguments("003"),
                Arguments.arguments("120"),
                Arguments.arguments("103"),
                Arguments.arguments("907")
        );
    }
}