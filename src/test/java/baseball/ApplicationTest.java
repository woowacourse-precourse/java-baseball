package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
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

    /* 게임 진행 테스트 */
    @Test
    @DisplayName("정상 동작하는 경우 테스트")
    void SuccessPlayGame() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("135", "2");
                    assertThat(output()).contains("3스트라이크", "게임 종료");
                },
                1, 3, 5
        );
    }

    /* 재시작 또는 완전종료 선택 입력값 테스트 */
    @Test
    @DisplayName("재시작, 완전종료 선택값에 없는 값을 입력하는 경우 테스트1")
    void ExceptionInputCommandIfNotIncludedInCommands1() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("135", "#"))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                1,3,5
        );
    }

    @Test
    @DisplayName("재시작, 완전종료 선택값에 없는 값을 입력하는 경우 테스트2")
    void ExceptionInputCommandIfNotIncludedInCommands2() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("135", "0"))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                1,3,5
        );
    }

    @Test
    @DisplayName("재시작, 완전종료 선택값에 없는 값을 입력하는 경우 테스트3")
    void ExceptionInputCommandIfNotIncludedInCommands3() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("135", "11"))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                1,3,5
        );
    }

    /* 플레이어가 입력한 예상값 테스트 */
    @Test
    @DisplayName("플레이어 예상값 입력에서 범위에 맞는 값이 아닌경우 테스트1")
    void ExceptionInputPlayerNumberIfItIsNotRange1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("dfa"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("플레이어 예상값 입력에서 범위에 맞는 값이 아닌경우 테스트2")
    void ExceptionInputPlayerNumberIfItIsNotRange2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("120"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("플레이어 예상값 입력에서 중복되는 값 있는 경우 테스트")
    void ExceptionInputPlayerNumberIfItHasDuplicateNumbers() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("111"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("플레이어 예상값 입력에서 3자리가 아닌경우 테스트1")
    void ExceptionInputPlayerNumberIfSizeIsNotBALL_COUNT1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("플레이어 예상값 입력에서 3자리가 아닌경우 테스트2")
    void ExceptionInputPlayerNumberIfSizeIsNotBALL_COUNT2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
