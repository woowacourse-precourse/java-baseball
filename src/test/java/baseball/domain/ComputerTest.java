package baseball.domain;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ComputerTest {

    private static Collection<Arguments> param1() {
        return Arrays.asList(
            Arguments.of("{123, 123} -> 3스트라이크",
                List.of(Ball.of(1, 1), Ball.of(2, 2), Ball.of(3, 3)),
                new Computer(List.of(Ball.of(1, 1), Ball.of(2, 2), Ball.of(3, 3))), "3스트라이크"),
            Arguments.of("{321, 123} -> 2볼 1스트라이크",
                List.of(Ball.of(3, 1), Ball.of(2, 2), Ball.of(1, 3)),
                new Computer(List.of(Ball.of(1, 1), Ball.of(2, 2), Ball.of(3, 3))), "2볼 1스트라이크"),
            Arguments.of("{456, 123} -> 낫싱",
                List.of(Ball.of(4, 1), Ball.of(5, 2), Ball.of(6, 3)),
                new Computer(List.of(Ball.of(1, 1), Ball.of(2, 2), Ball.of(3, 3))), "낫싱"),
            Arguments.of("{189, 123} -> 1스트라이크",
                List.of(Ball.of(1, 1), Ball.of(8, 2), Ball.of(9, 3)),
                new Computer(List.of(Ball.of(1, 1), Ball.of(2, 2), Ball.of(3, 3))), "1스트라이크"),
            Arguments.of("{781, 123} -> 1볼",
                List.of(Ball.of(7, 1), Ball.of(8, 2), Ball.of(1, 3)),
                new Computer(List.of(Ball.of(1, 1), Ball.of(2, 2), Ball.of(3, 3))), "1볼")
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("param1")
    void test1(String description, List<Ball> balls, Computer computer, String ans) {
        String result = computer.getResult(balls);
        Assertions.assertTrue(ans.equals(result));
    }
}
