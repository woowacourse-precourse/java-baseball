package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 스트라이크볼_판정테스트() {
        assertRandomNumberInRangeTest(
                ()->{
                    run("567","123","692","952","246","146","2");
                    assertThat(output()).contains("1볼","1스트라이크","1볼","낫싱","2스트라이크","3스트라이크");
                    },
                1,4,6,7,8
        );
    }
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

    void 예외테스트1(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("554"))
                        .isInstanceOf(IllegalArgumentException.class));
    }
    @Test
    void 예외테스트2(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("54"))
                        .isInstanceOf(IllegalArgumentException.class));
    }
    @Test
    void 예외테스트3(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("3j5"))
                        .isInstanceOf(IllegalArgumentException.class));
    }
}
