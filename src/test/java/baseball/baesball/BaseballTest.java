package baseball.baesball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static baseball.exception.BaseballException.BASEBALL_SIZE_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThat;

class BaseballTest {
    @ParameterizedTest(name = "[{index}] balls = {0}")
    @MethodSource("whenCreateBaseballThenSuccessDummy")
    @DisplayName("야구공 생성 성공 테스트")
    void whenCreateBaseballThenSuccessTest(List<Integer> balls) {
        Baseball baseball = new Baseball(balls);
        List<Integer> findBaseballs = baseball.getBaseballs();
        assertThat(findBaseballs).containsExactlyInAnyOrderElementsOf(balls);
    }

    @ParameterizedTest(name = "[{index}] balls = {0}")
    @MethodSource("whenCreateBaseballWrongThenExceptionDummy")
    @DisplayName("틀린 야구공 개수 생성 실패 예외처리 테스트")
    void whenCreateBaseballWrongThenExceptionTest(List<Integer> balls) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Baseball(balls))
                .withMessageMatching(BASEBALL_SIZE_EXCEPTION.getMessage());
    }

    static Stream<Arguments> whenCreateBaseballThenSuccessDummy() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 3)),
                Arguments.arguments(List.of(2, 3, 4)),
                Arguments.arguments(List.of(1, 7, 5)),
                Arguments.arguments(List.of(5, 2, 3)),
                Arguments.arguments(List.of(8, 3, 9)),
                Arguments.arguments(List.of(5, 4, 3)),
                Arguments.arguments(List.of(1, 8, 6)),
                Arguments.arguments(List.of(7, 1, 8)),
                Arguments.arguments(List.of(3, 6, 4)),
                Arguments.arguments(List.of(4, 5, 3))
        );
    }

    static Stream<Arguments> whenCreateBaseballWrongThenExceptionDummy() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 4, 6, 1, 3, 5)),
                Arguments.arguments(List.of(2, 3, 4, 6, 3, 3, 5)),
                Arguments.arguments(List.of(5, 2, 4, 6, 7, 3, 5)),
                Arguments.arguments(List.of(8, 3, 4, 6, 4, 6, 5)),
                Arguments.arguments(List.of(7, 1, 4, 6, 1, 3, 5)),
                Arguments.arguments(List.of(4, 5, 4, 6, 1, 3, 5)),
                Arguments.arguments(List.of(1, 7, 1, 3, 5)),
                Arguments.arguments(List.of(1, 8, 1, 3, 5)),
                Arguments.arguments(List.of(3, 6)),
                Arguments.arguments(List.of(3))
        );
    }
}