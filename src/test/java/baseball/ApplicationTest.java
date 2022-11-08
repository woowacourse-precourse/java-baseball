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
                1, 3, 5, 5, 8, 9 //컴퓨터에 저장되는 값
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
    void 예외_영어입력()
    {
        assertSimpleTest(()->
            assertThatThrownBy(()-> runException("abc"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_중복숫자입력()
    {
        assertSimpleTest(()->
            assertThatThrownBy(()-> runException("113"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_중복숫자입력2()
    {
        assertSimpleTest(()->
            assertThatThrownBy(()-> runException("131"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_한글입력()
    {
        assertSimpleTest(()->
            assertThatThrownBy(()-> runException("유준혁"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_두자리수만입력()
    {
        assertSimpleTest(()->
            assertThatThrownBy(()-> runException("12"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자야구도중_1입력()
    {
        assertSimpleTest(()->
            assertThatThrownBy(()-> runException("1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자야구도중_2입력()
    {
        assertSimpleTest(()->
            assertThatThrownBy(()-> runException("2"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
