package baseball.baesball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Stream;

import static baseball.exception.ConsoleException.BASEBALL_INPUT_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class PlayerBaseballGeneratorTest {
    private final BaseballGenerator baseballGenerator = new PlayerBaseballGenerator();

    @ParameterizedTest(name = "[{index}] balls = {0}")
    @MethodSource("whenPlayerGenerateBaseballThenSuccessDummy")
    @DisplayName("게임 플레이어 야구공 생성 성공 테스트")
    void whenPlayerGenerateBaseballThenSuccessTest(String balls) {
        System.setIn(new ByteArrayInputStream(balls.getBytes(StandardCharsets.UTF_8)));
        Baseball baseball = baseballGenerator.generateBaseball();
        List<Integer> findBaseballs = baseball.getBaseballs();
        assertThat(findBaseballs).hasSize(balls.length());
    }

    @ParameterizedTest(name = "[{index}] balls = {0}")
    @MethodSource("whenCreateBaseballWrongThenExceptionDummy")
    @DisplayName("틀린 야구공 개수 생성 실패 예외처리 테스트")
    void whenCreateBaseballWrongThenExceptionTest(String balls) {
        System.setIn(new ByteArrayInputStream(balls.getBytes(StandardCharsets.UTF_8)));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(baseballGenerator::generateBaseball)
                .withMessageMatching(BASEBALL_INPUT_EXCEPTION.getMessage());
    }

    static Stream<Arguments> whenPlayerGenerateBaseballThenSuccessDummy() {
        return Stream.of(
                Arguments.arguments("123"),
                Arguments.arguments("234"),
                Arguments.arguments("175"),
                Arguments.arguments("523"),
                Arguments.arguments("839"),
                Arguments.arguments("543"),
                Arguments.arguments("186"),
                Arguments.arguments("718"),
                Arguments.arguments("364"),
                Arguments.arguments("453")
        );
    }

    static Stream<Arguments> whenCreateBaseballWrongThenExceptionDummy() {
        return Stream.of(
                Arguments.arguments("1246135"),
                Arguments.arguments("2346335"),
                Arguments.arguments("5246735"),
                Arguments.arguments("8346465"),
                Arguments.arguments("7146135"),
                Arguments.arguments("4546135"),
                Arguments.arguments("544265"),
                Arguments.arguments("17135")
        );
    }
}