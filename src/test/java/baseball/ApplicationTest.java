package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void check_Only_Ball() {  // 볼만 나오는 경우를 검증
        assertRandomNumberInRangeTest(
                () -> {
                    run("263", "541", "513", "135", "2");
                    assertThat(output()).contains("1볼", "2볼", "3볼", "3스트라이크", "게임 종료");
                },
                1, 3, 5
        );
    }

    @Test
    void check_Only_Strike() {  // 스트라이크만 나오는 경우를 검증
        assertRandomNumberInRangeTest(
                () -> {
                    run("146", "136", "135", "2");
                    assertThat(output()).contains("1스트라이크", "2스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5
        );
    }

    @Test
    void check_Ball_With_Strike() {  // 볼과 스트라이크가 같이 나오는 경우를 검증
        assertRandomNumberInRangeTest(
                () -> {
                    run("163", "153", "135", "2");
                    assertThat(output()).contains("1볼 1스트라이크", "2볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5
        );
    }

    @Test
    void check_Nothing_And_Restart() {  // 낫싱과 새로운 게임을 다시 시작하는 경우를 검증
        assertRandomNumberInRangeTest(
                () -> {
                    run("248", "135", "1", "135", "268", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "낫싱", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 2, 6, 8
        );
    }

    @Test
    void exception_Case1() {    // 세 자리가 아닌 숫자가 입력되었을 때 검증
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void exception_Case2() {    // 중복되는 숫자가 있는 3자리 수
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("221"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void exception_Case3() {    // 숫자가 아닌 다른 문자가 섞여 있는 경우
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("5%6"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void exception_Case4() {    // 허용되는 숫자 범위를 벗어난 경우
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("904"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
