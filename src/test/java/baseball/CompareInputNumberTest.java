package baseball;

import baseball.model.CompareInputNumber;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompareInputNumberTest {
    CompareInputNumber compareInput;

    static Stream<Arguments> RandomandUserNumber() {
        return Stream.of(
                Arguments.arguments(Arrays.asList(1, 5, 7), Arrays.asList(1, 5, 7), Arrays.asList(0, 3)),
                Arguments.arguments(Arrays.asList(1, 5, 7), Arrays.asList(1, 6, 5), Arrays.asList(1, 1)),
                Arguments.arguments(Arrays.asList(1, 5, 7), Arrays.asList(2, 8, 9), Arrays.asList(0, 0)),
                Arguments.arguments(Arrays.asList(1, 5, 7), Arrays.asList(1, 7, 5), Arrays.asList(2, 1)),
                Arguments.arguments(Arrays.asList(1, 5, 7), Arrays.asList(5, 7, 1), Arrays.asList(3, 0))

        );
    }

    @ParameterizedTest
    @MethodSource("RandomandUserNumber")
    void compareNumber(List<Integer> random, List<Integer> user, List<Integer> expected){
        compareInput = new CompareInputNumber();
        List<Integer> actual = compareInput.compareRandomandUser(random, user);
        assertEquals(expected, actual);
    }
}
