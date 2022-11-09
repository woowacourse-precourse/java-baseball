package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputExceptionTest extends NsTest {

    @Test
    void 매우_긴_숫자_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("11989438894342892849328498329489324892348923489324892348932489324423234234234234234234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 세_자리가_아닌_숫자() {
        assertThatThrownBy(() -> runException("1"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> runException("12"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> runException("12345"))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 숫자_외의_문자_또는_공백_입력() {

        assertThatThrownBy(() -> runException("가나다"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> runException("ABC"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> runException("@*!"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> runException("   "))
                .isInstanceOf(IllegalArgumentException.class);

    }


    @Test
    void 중복된_숫자_입력() {
        assertThatThrownBy(() -> runException("112233"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> runException("133"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> runException("111"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_0이_포함된_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("102"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
