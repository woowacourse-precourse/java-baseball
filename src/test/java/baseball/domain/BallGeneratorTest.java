package baseball.domain;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BallGeneratorTest {

    private static Collection<Arguments> param1() {
        return Arrays.asList(
            Arguments.of("4글자 입력은 에러 출력", "1234"),
            Arguments.of("2글자 입력은 에러 출력", "12"),
            Arguments.of("숫자가 아닌 입력은 에러 출력", "ㄱㄴㄷ"),
            Arguments.of("숫자가 아닌 입력은 에러 출력", "가나다"),
            Arguments.of("숫자가 아닌 입력은 에러 출력", "가23"),
            Arguments.of("숫자가 아닌 입력은 에러 출력", "#23")
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("param1")
    void test1(String message, String input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> BallGenerator.getBalls(input));
    }

    private static Collection<Arguments> param2() {
        return Arrays.asList(
            Arguments.of("{123} -> 123", "123", List.of(1, 2, 3)),
            Arguments.of("{523} -> 523", "523", List.of(5, 2, 3))
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("param2")
    void test2(String message, String input, List<Integer> result) {
        List<Ball> balls = BallGenerator.getBalls(input);
        IntStream.range(0, 3).forEach(i -> Assertions.assertEquals(result.get(i), balls.get(i).getNumber()));
        IntStream.range(0, 3).forEach(i -> Assertions.assertEquals(i+1, balls.get(i).getPosition()));
    }
}
