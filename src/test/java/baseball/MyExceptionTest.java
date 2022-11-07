package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MyExceptionTest extends NsTest {
    @Test
    void 한글이_입력되면_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("하나둘"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 영어가_입력되면_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 숫자와_영어_혼용_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1ad"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 중복값_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("112"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 공백_삭제하여_정상작동() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246  ", "13  5", "1 ", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }
    @Test
    void 자리수_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 잘못된숫자_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("012"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 공백포함_3글자_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" 12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 재시작_입력_예외처리() {
        assertThatThrownBy(() -> assertRandomNumberInRangeTest(
                () -> {
                    run("246  ", "13  5", "0 ", "597", "589", "2");
                },
                1, 3, 5, 5, 8, 9
        )).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 재시작_숫자외의_값_예외처리() {
        assertThatThrownBy(() -> assertRandomNumberInRangeTest(
                () -> {
                    run("246  ", "13  5", "하나 ", "597", "589", "2");
                },
                1, 3, 5, 5, 8, 9
        )).isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
