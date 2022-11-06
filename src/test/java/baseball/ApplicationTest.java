package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import java.util.List;
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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void play_예외1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void play_예외2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("aaa"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void randomNumTest() {
        assertThat(Application.randomNum().length()).isEqualTo(3);
        for (int randomNumIdx = 0; randomNumIdx < 3; randomNumIdx++) {
            assertThat(Application.randomNum().charAt(randomNumIdx)).isBetween('1', '9');
        }
    }

    @Test
    void isNumTest() {
        assertThat(Application.isNum("123")).isTrue();
        assertThat(Application.isNum("abc")).isFalse();
    }

    @Test
    void correctOrHintTest() {
        assertThat(Application.correctOrHint("123", "123")).isTrue();
        assertThat(output()).contains("3스트라이크");
        assertThat(Application.correctOrHint("456", "123")).isFalse();
        assertThat(output()).contains("낫싱");
        assertThat(Application.correctOrHint("451", "123")).isFalse();
        assertThat(output()).contains("1볼");
        assertThat(Application.correctOrHint("351", "123")).isFalse();
        assertThat(output()).contains("2볼");
        assertThat(Application.correctOrHint("231", "123")).isFalse();
        assertThat(output()).contains("3볼");
        assertThat(Application.correctOrHint("145", "123")).isFalse();
        assertThat(output()).contains("1스트라이크");
        assertThat(Application.correctOrHint("124", "123")).isFalse();
        assertThat(output()).contains("2스트라이크");
        assertThat(Application.correctOrHint("134", "123")).isFalse();
        assertThat(output()).contains("1볼 1스트라이크");
        assertThat(Application.correctOrHint("132", "123")).isFalse();
        assertThat(output()).contains("2볼 1스트라이크");
    }

    @Test
    void cntStrikeBallTest() {
        List<Integer> result1 = List.of(3, 0);
        List<Integer> result2 = List.of(0, 0);
        List<Integer> result3 = List.of(0, 1);
        List<Integer> result4 = List.of(0, 2);
        List<Integer> result5 = List.of(0, 3);
        List<Integer> result6 = List.of(1, 0);
        List<Integer> result7 = List.of(2, 0);
        List<Integer> result8 = List.of(1, 1);
        List<Integer> result9 = List.of(1, 2);

        assertThat(result1).isEqualTo(Application.cntStrikeBall("123", "123"));
        assertThat(result2).isEqualTo(Application.cntStrikeBall("456", "123"));
        assertThat(result3).isEqualTo(Application.cntStrikeBall("451", "123"));
        assertThat(result4).isEqualTo(Application.cntStrikeBall("351", "123"));
        assertThat(result5).isEqualTo(Application.cntStrikeBall("231", "123"));
        assertThat(result6).isEqualTo(Application.cntStrikeBall("145", "123"));
        assertThat(result7).isEqualTo(Application.cntStrikeBall("124", "123"));
        assertThat(result8).isEqualTo(Application.cntStrikeBall("134", "123"));
        assertThat(result9).isEqualTo(Application.cntStrikeBall("132", "123"));
    }
}
