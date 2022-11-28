package baseball.model;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberTest {

    @DisplayName("다른 index, 같은 value을 가졌다면 참을 반환한다")
    @ParameterizedTest
    @MethodSource("hasOnlyDifferentIndexTestSource")
    void hasOnlyDifferentIndexTest(Number number1, Number number2, boolean expected) {
        boolean actual = number1.hasOnlyDifferentIndexWith(number2);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("index와 value가 모두 같다면 같은 객체이다")
    @ParameterizedTest
    @MethodSource("equalsTestSource")
    void equalsTest(Number number1, Number number2, boolean expected) {
        assertThat(number1.equals(number2))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> hasOnlyDifferentIndexTestSource() {
        return Stream.of(
                Arguments.of(new Number(0, 1), new Number(1, 1), true),
                Arguments.of(new Number(1, 1), new Number(1, 1), false),
                Arguments.of(new Number(0, 1), new Number(1, 0), false)
        );
    }

    private static Stream<Arguments> equalsTestSource() {
        return Stream.of(
                Arguments.of(new Number(1, 1), new Number(1, 1), true),
                Arguments.of(new Number(1, 1), new Number(1, 2), false),
                Arguments.of(new Number(1, 1), new Number(2, 1), false)
        );
    }
}
