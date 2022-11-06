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
    void 한_게임_후_종료() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "게임 종료");
                },
                1, 3, 5
        );
    }

    @Test
    void 모든_결과_테스트_후_종료() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("136", "947", "127", "527", "825", "246", "287", "285", "259", "258", "2");
                    assertThat(output()).contains("낫싱", "낫싱", "1볼", "2볼", "3볼", "1스트라이크", "1볼 1스트라이크", "2볼 1스트라이크",
                            "2스트라이크", "3스트라이크", "게임 종료");
                },
                2, 5, 8
        );
    }

    @Test
    void 모든_결과_테스트_후_재시작_여러번() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("136", "947", "127", "527", "825", "246", "287", "285", "259", "258", "1",
                            "136", "947", "127", "527", "825", "246", "287", "285", "259", "258", "1",
                            "136", "947", "127", "527", "825", "246", "287", "285", "259", "258", "1",
                            "136", "947", "127", "527", "825", "246", "287", "285", "259", "258", "1",
                            "136", "947", "127", "527", "825", "246", "287", "285", "259", "258", "2");
                    assertThat(output()).contains("낫싱", "낫싱", "1볼", "2볼", "3볼", "1스트라이크", "1볼 1스트라이크", "2볼 1스트라이크",
                            "2스트라이크", "3스트라이크", "게임 종료",
                            "낫싱", "낫싱", "1볼", "2볼", "3볼", "1스트라이크", "1볼 1스트라이크", "2볼 1스트라이크",
                            "2스트라이크", "3스트라이크",
                            "낫싱", "낫싱", "1볼", "2볼", "3볼", "1스트라이크", "1볼 1스트라이크", "2볼 1스트라이크",
                            "2스트라이크", "3스트라이크",
                            "낫싱", "낫싱", "1볼", "2볼", "3볼", "1스트라이크", "1볼 1스트라이크", "2볼 1스트라이크",
                            "2스트라이크", "3스트라이크",
                            "낫싱", "낫싱", "1볼", "2볼", "3볼", "1스트라이크", "1볼 1스트라이크", "2볼 1스트라이크",
                            "2스트라이크", "3스트라이크", "게임 종료");
                },
                2, 5, 8, 2, 5, 8, 2, 5, 8, 2, 5, 8, 2, 5, 8
        );
    }

    @Test
    void 정답_후_종료_여러번() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("135", "1", "135", "1", "135", "1", "135", "1", "135", "1", "135", "1", "135", "1", "135",
                            "1", "135", "1", "135", "1", "135", "1", "135", "1", "135", "1", "135", "2");
                    assertThat(output()).contains("3스트라이크", "3스트라이크", "3스트라이크", "3스트라이크",
                            "게임 종료", "3스트라이크", "3스트라이크", "3스트라이크", "3스트라이크",
                            "3스트라이크", "3스트라이크", "3스트라이크", "3스트라이크", "3스트라이크",
                            "게임 종료", "3스트라이크", "게임 종료");
                },
                1, 3, 5,
                1, 3, 5,
                1, 3, 5,
                1, 3, 5,
                1, 3, 5,
                1, 3, 5,
                1, 3, 5,
                1, 3, 5,
                1, 3, 5,
                1, 3, 5,
                1, 3, 5,
                1, 3, 5,
                1, 3, 5,
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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
