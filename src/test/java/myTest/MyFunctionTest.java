package myTest;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MyFunctionTest extends NsTest {
    @Test
    void 예외_테스트_공백_문자_1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12 3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트_공백_문자_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1 2 3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트_공백_문자_3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" 123"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트_공백_문자_4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("123 "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트_숫자가_아닌_경우_1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,23"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트_숫자가_아닌_경우_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트_숫자가_아닌_경우_3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("ㅁ,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트_숫자가_아닌_경우_4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트_세자리_숫자_아닌_경우_1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트_세자리_숫자_아닌_경우_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("14"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트_세자리_숫자_아닌_경우_3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1425"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트_같은_숫자_존재_1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("112"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트_같은_숫자_존재_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("111"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트_같은_숫자_존재_3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1111"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
