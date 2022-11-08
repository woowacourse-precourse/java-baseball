package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

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
    void 스트라이크_확인() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("195", "238", "135", "2");
                    assertThat(output()).contains("2스트라이크", "1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5
        );
    }

    @Test
    void 볼_확인() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("521", "891", "135", "2");
                    assertThat(output()).contains("2볼", "1볼", "3스트라이크", "게임 종료");
                },
                1, 3, 5
        );
    }

    @Test
    void 낫싱_확인() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("892", "246", "135", "2");
                    assertThat(output()).contains("낫싱", "낫싱", "3스트라이크", "게임 종료");
                },
                1, 3, 5
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
    void 사용자_최초_입력값이_정답인_경우() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("135", "2");
                    assertThat(output()).contains("3스트라이크", "게임 종료");
                },
                1, 3, 5
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }


}
