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
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예측값입력_영문포함_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1ab"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예측값입력_한글포함_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1가나"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예측값입력_특수문자포함_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1!@"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예측값입력_공백포함_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1 3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예측값입력_중복포함_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("112"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예측값입력_영포함_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("103"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예측값입력_범위_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("94"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 명령입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> run("246", "135", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
