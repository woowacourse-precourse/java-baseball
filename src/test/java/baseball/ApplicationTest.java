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
    void customTestCase1(){
        assertRandomNumberInRangeTest(
            () -> {
                run("175", "247", "427", "1", "374", "958", "985", "1", "263", "265", "256", "156", "2");
                assertThat(output()).contains("1볼", "2볼 1스트라이크", "3스트라이크", "낫싱", "2볼", "2스트라이크", "게임 종료");
            },
            4, 2, 7, 9, 8, 5, 1, 5, 6
        );
    }

    @Test
    void readmeCase(){
        assertRandomNumberInRangeTest(
            () -> {
                run("123", "145", "671", "216", "713", "1", "123", "415", "419", "491", "2");
                assertThat(output()).contains("1볼 1스트라이크", "1볼", "2볼", "1스트라이크", "3스트라이크", "2볼 1스트라이크", "게임 종료");
            },
            7, 1, 3, 4, 9, 1
        );
    }

    @Test
    void customTestCase2(){
        assertRandomNumberInRangeTest(
            () -> {
                assertThatThrownBy(() -> runException("315", "153", "513", "0"))
                    .isInstanceOf(IllegalArgumentException.class);
            },
            5, 1, 3
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
