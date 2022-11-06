package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class BallsTest {
    private Balls balls;
    @BeforeEach
    public void setUp() {
        balls = new Balls(List.of(1,2,3));
    }

    @DisplayName("예외처리 테스트")
    @ParameterizedTest
    @MethodSource("generateArgumentsStream")
    public void exceptionTest(List<Integer> balls) {
        assertThatThrownBy(() -> {
            new Balls(balls);
        }).isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("hasSameValue")
    @ParameterizedTest
    @CsvSource({"1,true","4,false"})
    public void hasSameValueTest(int number, boolean result) {
        assertThat(balls.hasSameValue(new Ball(number))).isEqualTo(result);
    }
    @DisplayName("inSamePosition")
    @ParameterizedTest
    @CsvSource({"0,1,true","2,1,false"})
    public void inSamePositionTest(int position, int number, boolean result) {
        assertThat(balls.inSamePosition(position, new Ball(number))).isEqualTo(result);
    }

    private static Stream<Arguments> generateArgumentsStream() {
        List<Arguments> listOfArguments = new LinkedList<>();
        listOfArguments.add(Arguments.of(List.of(1,2)));
        listOfArguments.add(Arguments.of(List.of(1,2,3,4)));
        listOfArguments.add(Arguments.of(List.of(1,1,2)));
        return listOfArguments.stream();
    }
}
