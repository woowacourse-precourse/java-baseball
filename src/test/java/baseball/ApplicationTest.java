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
    void 입력_자릿수_예외_테스트1_네자리수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력_자릿수_예외_테스트2_두자리수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력_자릿수_예외_테스트3_한자리수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력값에_0이_포함된_예외_테스트1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("120"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력값에_0이_포함된_예외_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("102"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력값에_0이_포함된_예외_테스트3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("012"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력값에_중복되는_숫자가_있는_예외_테스트1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("122"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력값에_중복되는_숫자가_있는_예외_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("212"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력값에_중복되는_숫자가_있는_예외_테스트3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("221"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력값에_중복되는_숫자가_있는_예외_테스트4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("222"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 게임종료_후_다음_진행을_입력할때_잘못된_입력_예외_테스트() {
        assertRandomNumberInRangeTest(
                () -> assertThatThrownBy(() -> runException("246", "135", "0"))
                        .isInstanceOf(IllegalArgumentException.class),
                1, 3, 5
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
