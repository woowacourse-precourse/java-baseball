package baseball.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class BallsTest {
    private Balls balls;

    @BeforeEach
    public void setUp() {
        balls = new Balls(List.of(1,2,3));
    }

    @DisplayName("1단계 : 예외처리 테스트")
    @ParameterizedTest
    @MethodSource("generateForException")
    public void exceptionTest(List<Integer> balls) {
        assertThatThrownBy(() -> {
            new Balls(balls);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("2단계 : hasSameValue")
    @ParameterizedTest
    @CsvSource({"1,true","4,false"})
    public void hasSameValueTest(int number, boolean result) {
        assertThat(balls.hasSameValue(new Ball(number))).isEqualTo(result);
    }

    @DisplayName("2단계 : inSamePosition")
    @ParameterizedTest
    @CsvSource({"0,1,true","2,1,false"})
    public void inSamePositionTest(int position, int number, boolean result) {
        assertThat(balls.inSamePosition(position, new Ball(number))).isEqualTo(result);
    }

    @DisplayName("3단계 : play Strike")
    @Test
    public void playStrikeTest() {
        assertThat(balls.play(0,new Ball(1))).isEqualTo(Optional.of(Judgement.STRIKE));
    }

    @DisplayName("3단계 : play Ball")
    @Test
    public void playBallTest() {
        assertThat(balls.play(0, new Ball(2))).isEqualTo(Optional.of(Judgement.BALL));
    }

    private static Stream<Arguments> generateForException() {
        List<Arguments> listOfArguments = new LinkedList<>();
        listOfArguments.add(Arguments.of(List.of(1,2)));
        listOfArguments.add(Arguments.of(List.of(1,2,3,4)));
        listOfArguments.add(Arguments.of(List.of(1,1,2)));
        return listOfArguments.stream();
    }
}
