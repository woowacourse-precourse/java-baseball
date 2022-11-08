package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.lang.*;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "1", "485", "476", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9, 4, 7, 6
        );
    }

    @Test
    void 예외_테스트_세자리수_이상_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Application.IllegalArgumentException())
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 예외_테스트_세자리수_미만_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("14"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 예외_테스트_0값_포함_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("104"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 예외_테스트_숫자_외_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a13"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
            Application.main(new String[]{});
    }
}
