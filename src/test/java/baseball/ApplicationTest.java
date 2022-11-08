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
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void case1() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "783", "159", "951", "3", "2");
                    assertThat(output()).contains("낫싱", "낫싱", "2볼 1스트라이크", "3스트라이크", "1 또는 2", "종료");
                },
                9, 5, 1
        );
    }
    @Test

    void case2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("123", "145", "671", "216", "713", "1", "123", "456", "789", "641", "642", "246", "2");
                    assertThat(output()).contains("시작합니다", "1볼 1스트라이크", "1볼", "2볼",
                            "1스트라이크", "3스트라이크", "게임 종료", "1볼","1볼 1스트라이크", "낫싱",
                            "1볼 1스트라이크", "2볼 1스트라이크", "3스트라이크", "게임 종료", "프로그램이 종료");
                },
                7, 1, 3, 2, 4, 6
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
