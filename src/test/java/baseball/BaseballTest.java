package baseball;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballTest {
    private final static int NUMBER_LIMIT = 3;
    private static BaseballGame sut;

    @BeforeAll
    static void initialization() {
        sut = new BaseballGame();
    }

    static Stream<Arguments> generateBallTestData() {
        return Stream.of(
                Arguments.of(123, 321, 2),
                Arguments.of(568, 658, 2),
                Arguments.of(869, 698, 3),
                Arguments.of(623, 236, 3),
                Arguments.of(562, 236, 2),
                Arguments.of(568, 265, 1)
        );
    }

    @Test
    void getStrike_각_자리에_맞는_스트라이크의_갯수_반환() {
        assertThat(sut.getStrike(123, 163)).isEqualTo(2);
        assertThat(sut.getStrike(123, 273)).isEqualTo(1);
    }

    @Test
    void getStrike_모든_숫자가_맞았을_경우_정답의_자리수와_같은_수_반환() {
        assertThat(sut.getStrike(123, 123)).isEqualTo(NUMBER_LIMIT);
    }

    @Test
    void getStrike_아무것도_맞지_않으면_0_반환() {
        assertThat(sut.getStrike(123, 456)).isEqualTo(0);
    }

    @Test
    void getBall_입력한_숫자가_정답에_포함된_갯수_반환() {
        assertThat(sut.getBall(123, 321)).isEqualTo(3);
        assertThat(sut.getBall(134, 431)).isEqualTo(3);
    }

    @Test
    void getBall_아무_숫자가_포함되지_않을_경우_0_반환() {
        assertThat(sut.getBall(123, 456)).isEqualTo(0);
    }

    @ParameterizedTest(name = "[{index}] 입력값이 {0}이고, 정답이 {1}이면 정확한 볼의 갯수는 {2}")
    @MethodSource("generateBallTestData")
    void getBall_정확한_볼의_갯수_찾기(int source, int target, int expected) {
        int actual = sut.getBall(source, target) - sut.getStrike(source, target);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void getRandomNumber_1에서_9까지_서로_다른_난수를_반환() {
        for (int i = 0; i < 4; i++) {
            String random = Integer.toString(sut.getRandomNumber());
            int actual = new HashSet<>(List.of(random.split(""))).size();
            assertThat(actual).isEqualTo(NUMBER_LIMIT);
        }
    }

    @Test
    void getRandomNumber_정해진_자리수와_같은_자리수의_난수를_반환() {
        for (int i = 0; i < 4; i++) {
            int actual = Integer.toString(sut.getRandomNumber()).length();
            assertThat(actual).isEqualTo(NUMBER_LIMIT);
        }
    }

}
