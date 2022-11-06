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
    void 게임중_입력_예외_테스트1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 게임중_입력_예외_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("115"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 게임후_입력_예외_테스트() {
        assertThatThrownBy(() -> Application.isValidInputAfterGame("3"))
                        .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 서로다른_3자리_숫자_생성_테스트() {
        String test = Application.createThreeDigitNumber();
        assertThat(test.length()).isEqualTo(3);
        assertThat(test.charAt(0)).isNotEqualTo(test.charAt(1)).isNotEqualTo(test.charAt(2));
        assertThat(test.charAt(1)).isNotEqualTo(test.charAt(2));
    }

    @Test
    void 정답비교_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("789", "189", "139", "781", "731", "753", "153", "513", "135", "2");
                    assertThat(output()).contains("낫싱", "1스트라이크", "2스트라이크", "1볼", "1볼 1스트라이크", "2볼", "2볼 1스트라이크", "3볼", "3스트라이크", "게임 종료", "새로 시작");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
