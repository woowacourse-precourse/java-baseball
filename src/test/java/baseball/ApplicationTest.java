package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

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
    void 모든_결과_후_종료() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("146", "793", "783", "761", "785", "738", "864", "876", "873", "2");
                    assertThat(output()).contains("낫싱", "1볼 1스트라이크", "2볼 1스트라이크", "1볼", "2볼", "3볼", "1스트라이크", "2스트라이크",
                            "3스트라이크", "게임 종료");
                },
                8, 7, 3
        );
    }

    @Test
    void 계속해서_게임_재시작_후_종료() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("429", "1", "542", "1", "298", "1", "536", "1", "743", "1", "519", "1", "693", "2");
                    assertThat(output()).contains("3스트라이크", "게임 종료");
                },
                4, 2, 9, 5, 4, 2, 2, 9, 8, 5, 3, 6, 7, 4, 3, 5, 1, 9, 6, 9, 3
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
}
