package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @MethodSource("providePlayTestcase")
    @DisplayName("play 함수가 정상적으로 게임 결과를 계산하는지 확인한다")
    void playTest(List<Integer> comNumber, List<Integer> userNumber, GameResult result) {
        Player computer = new Player(comNumber);
        Player user = new Player(userNumber);
        GameResult gameResult = Application.play(computer, user);
        Assertions.assertThat(gameResult).isEqualTo(result);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    private static Stream<Arguments> providePlayTestcase() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3), new GameResult(3, 0)),
                Arguments.of(Arrays.asList(3, 2, 1), Arrays.asList(1, 2, 3), new GameResult(1, 2)),
                Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), new GameResult(0, 0)));
    }

}
