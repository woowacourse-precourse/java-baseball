package baseball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class PlayerTest extends NsTest {

    @Test
    void 입력_사이즈_관련_예외처리() {
        assertAll(
                () -> assertThatThrownBy(() -> runException("1")).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> runException("23")).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> runException("4567")).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> runException("89123")).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력_범위_관련_예외처리() {
        assertAll(
                () -> assertThatThrownBy(() -> runException("210")).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> runException("ab2")).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력_서로_다른_숫자인지_확인() {
        assertAll(
                () -> assertThatThrownBy(() -> runException("111")).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> runException("233")).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> runException("818")).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
