package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

import static baseball.Application.*;
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

    @Test
    void IntegerToList_test(){
        assertThat(IntegerToList(369)).isEqualTo(Arrays.asList(3, 6, 9));
        assertThat(IntegerToList(2580)).isEqualTo(Arrays.asList(2, 5, 8, 0));
    }

    @Test
    void checkUserInput_test(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("23"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void playball_test(){
        assertThat(playball(123,456))
                .isEqualTo(Map.of(
                        "Ball", 0,
                        "Strike", 0));

        assertThat(playball(123,142))
                .isEqualTo(Map.of(
                        "Ball", 1,
                        "Strike", 1));

        assertThat(playball(123,123))
                .isEqualTo(Map.of(
                        "Ball", 0,
                        "Strike", 3));
    }

    @Test
    void printResult_test(){
        assertThat(printResult(Map.of(
                "Ball", 0,
                "Strike", 0)))
                .isEqualTo("낫싱");

        assertThat(printResult(Map.of(
                "Ball", 1,
                "Strike", 0)))
                .isEqualTo("1볼");

        assertThat(printResult(Map.of(
                "Ball", 2,
                "Strike", 1)))
                .isEqualTo("2볼 1스트라이크");
    }

    @Test
    void determineAnswer_test(){
        assertThat(determineAnswer())
                .isGreaterThan(99)
                .isLessThan(1000);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
