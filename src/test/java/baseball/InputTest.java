package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Test;

public class InputTest extends NsTest {
    @Test
    void 숫자_자리수_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 범위_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 중복_숫자_2개_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("121"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 중복_숫자_3개_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("555"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 종료_재시작_코드_예외_테스트() {
        String input = "0";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(Input::restartOrEnd)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 종료_재시작_코드_예외_테스트2() {
        String input = "a";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(Input::restartOrEnd)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
