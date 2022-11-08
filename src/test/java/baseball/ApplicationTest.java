package baseball;

import baseball.exception.Exception;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    Exception exception = new Exception();

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
    void 입력값_길이_작을_때_예외_테스트() {
        String input = "1";
        int rightLength = 3;
        assertSimpleTest(() ->
                assertThatThrownBy(() -> exception.validateInputLength(input, rightLength))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("길이가 " + rightLength + "인 수를 입력해주세요.")
        );
    }

    @Test
    void 입력값_길이_길_때_예외_테스트() {
        String input = "1234";
        int rightLength = 3;
        assertSimpleTest(() ->
                assertThatThrownBy(() -> exception.validateInputLength(input, rightLength))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("길이가 " + rightLength + "인 수를 입력해주세요.")
        );
    }

    @Test
    void 입력값_중복_테스트() {
        String input = "112";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> exception.validateIsDuplicate(input))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("중복된 숫자를 입력하지 말아주세요.")
        );
    }

    @Test
    void 입력값_특정값_사이_테스트() {
        String input = "012";
        char startNumber = '1';
        char endNumber = '9';
        assertSimpleTest(() ->
                assertThatThrownBy(() -> exception.validateIsNumeric(input, startNumber, endNumber))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(startNumber + "~" + endNumber + "사이의 숫자만 입력해주세요.")
        );
    }

    @Test
    void 재시작_입력값_길이_짧을_때_테스트() {
        String input = "";
        int rightLength = 1;
        assertSimpleTest(() ->
                assertThatThrownBy(() -> exception.validateInputLength(input, rightLength))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("길이가 " + rightLength + "인 수를 입력해주세요.")
        );
    }

    @Test
    void 재시작_입력값_길이_길_때_테스트() {
        String input = "123456";
        int rightLength = 1;
        assertSimpleTest(() ->
                assertThatThrownBy(() -> exception.validateInputLength(input, rightLength))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("길이가 " + rightLength + "인 수를 입력해주세요.")
        );
    }

    @Test
    void 재시작_입력값_특정값_사이_테스트() {
        String input = "7";
        char startNumber = '1';
        char endNumber = '2';
        assertSimpleTest(() ->
                assertThatThrownBy(() -> exception.validateIsNumeric(input, startNumber, endNumber))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(startNumber + "~" + endNumber + "사이의 숫자만 입력해주세요.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
