package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.NumberAssert;
import org.junit.jupiter.api.Nested;
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

    // 갯수
    @Test
    void 사용자_숫자_갯수_테스트1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 사용자_숫자_갯수_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // 공백
    @Test
    void 사용자_숫자_공백_테스트1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1  "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 사용자_숫자_공백_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" 2 "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 사용자_숫자_공백_테스트3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("   "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // 숫자 중복 테스트
    @Test
    void 사용자_숫자_중복_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("111"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // 숫자 여부 테스트
    @Test
    void 사용자_숫자_여부_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("가나다"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 컴퓨터_숫자_갯수_테스트() {
        assertThat(Application.comNumber().size()==3);
    }
}
