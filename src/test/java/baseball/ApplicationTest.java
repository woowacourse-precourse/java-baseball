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
    void 게임종료_후_재시작2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("245", "145", "1", "597", "579", "2");
                    assertThat(output()).contains("2스트라이크", "3스트라이크", "2볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 4, 5, 5, 7, 9
        );
    }
    @Test
    void 게임종료_후_재시작3() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("245", "1", "597", "579", "2");
                    assertThat(output()).contains("3스트라이크", "2볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                2, 4, 5, 5, 7, 9
        );
    }
    @Test
    void 게임종료_후_재시작4() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("243", "245", "1", "597", "123","579", "2");
                    assertThat(output()).contains("2스트라이크", "3스트라이크", "2볼 1스트라이크", "낫싱","3스트라이크", "게임 종료");
                },
                2, 4, 5, 5, 7, 9
        );
    }
    @Test
    void 게임종료_후_재시작5() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("812", "158", "813","1", "597", "123","423", "1","582","2");
                    assertThat(output()).contains("2스트라이크", "2볼","3스트라이크", "낫싱","2스트라이크", "3스트라이크","게임 종료");
                },
                8, 1,3, 4,2,3,5,8,2
        );
    }

    @Test
    void 게임종료_테스트1() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("412", "341", "456","2");
                    assertThat(output()).contains("1스트라이크", "1볼", "3스트라이크", "게임 종료");
                },
                4, 5, 6
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
    void 예외_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(""))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("115"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
