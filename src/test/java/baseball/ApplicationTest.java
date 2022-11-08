package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static baseball.Application.getResult;
import static baseball.Application.validateUserNumbers;

class ApplicationTest extends NsTest {
    @Test
    void 숫자_결과_테스트() {
        String answer = "723";
        String case1 = "723";
        String case2 = "327";
        String case3 = "192";
        String case4 = "946";

        String resultCase1 = getResult(answer, case1);
        String resultCase2 = getResult(answer, case2);
        String resultCase3 = getResult(answer, case3);
        String resultCase4 = getResult(answer, case4);

        assertThat(resultCase1).isEqualTo("3스트라이크");
        assertThat(resultCase2).isEqualTo("2볼 1스트라이크");
        assertThat(resultCase3).isEqualTo("1볼");
        assertThat(resultCase4).isEqualTo("낫싱");
    }

    @Test
    void 숫자_검증_테스트() {
        assertThatThrownBy(() -> validateUserNumbers("333"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validateUserNumbers("4315"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validateUserNumbers("012"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validateUserNumbers("34"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validateUserNumbers("abc"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validateUserNumbers("우테코"))
                .isInstanceOf(IllegalArgumentException.class);

        validateUserNumbers("123");
        validateUserNumbers("465");
    }

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
    void 예외_테스트_중복숫자_입력() {
        assertSimpleTest(
                () -> assertThatThrownBy(() -> runException("133"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_다른문자_입력() {
        assertSimpleTest(
                () -> assertThatThrownBy(() -> runException("abc"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
