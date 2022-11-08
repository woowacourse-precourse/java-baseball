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
    void 입력된_숫자가_3개_보다_적은_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력에_숫자가_아닌_문자가_들어간_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력에_0이_들어간_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("120"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력에_중복값이_포함된_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("121"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 재시작에_1과_2_이외의_문자가_입력된_경우(){
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(()-> runException("851", "0"))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                8, 5, 1
        );
    }
    @Test
    void 게임종료() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("392", "128", "148", "841", "851", "2");
                    assertThat(output()).contains("낫싱", "2볼", "2스트라이크", "3스트라이크", "게임 종료");
                }, 8, 8, 5, 1
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
