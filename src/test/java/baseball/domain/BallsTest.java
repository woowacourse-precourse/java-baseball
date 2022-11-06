package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class BallsTest {
    private static Stream<Arguments> generateArgumentsStream() {
        List<Arguments> listOfArguments = new LinkedList<>();
        listOfArguments.add(Arguments.of(List.of(1,2)));
        listOfArguments.add(Arguments.of(List.of(1,2,3,4)));
        listOfArguments.add(Arguments.of(List.of(1,1,2)));
        return listOfArguments.stream();
    }
    @DisplayName("예외처리 테스트")
    @ParameterizedTest
    @MethodSource("generateArgumentsStream")
    public void exceptionTest(List<Integer> balls) {
        assertThatThrownBy(() -> {
            new Balls(balls);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
