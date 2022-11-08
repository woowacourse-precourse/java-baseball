package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void continue_exit_test() {     // 게임 재시작 or 종료 테스트
        assertRandomNumberInRangeTest(
                () -> {
                    run("123", "134", "135", "1", "567","589", "2");
                    assertThat(output()).contains("1볼 1스트라이크", "2스트라이크", "3스트라이크",
                            "1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9            // 랜덤 넘버가 135, 589
        );
    }

    // 입력 길이가 3이 아닌 경우
    @Test
    void illegal_input1_test() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("78"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("5555"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // 입력이 숫자가 아닌 경우
    @Test
    void illegal_input2_test(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc"))
                        .isInstanceOf(IllegalArgumentException.class));
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("!@#"))
                        .isInstanceOf(IllegalArgumentException.class));
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("   "))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    // 중복된 입력이 들어온 경우
    @Test
    void illegal_input3_test(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("111"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
