package baseball.model;

import baseball.model.BallNumbers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class BallParametersTest {
    private static Stream<Arguments> provideListCharInput() {
        return Stream.of(
                Arguments.of(List.of('3', '2', '1', '4'),
                        List.of('3', '3', '2'),
                        List.of('3', '3'),
                        List.of('7','8'))
        );
    }

    @ParameterizedTest
    @MethodSource("provideListCharInput")
    void if_duplicate_consecutive_num(List<Character> hits) {
        assertThrows(IllegalArgumentException.class, () -> new BallNumbers(hits));
    }
}
