package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    Application application = new Application();

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
    void generateAnswer_And_isValidInput_Test() {
        String answer = application.generateAnswer();
        boolean result = application.isValidInput(answer);
        assertThat(result).isEqualTo(true);
    }

    @Test
    void 숫자가_아닌_입력() {
        String[] inputs = {"12a", "1a2", "a12", " 12", "12#", "  ", ""};
        for (String input : inputs) {
            assertThat(application.isValidInput(input)).isEqualTo(false);
        }
    }

    @Test
    void 세_자리가_아닌_입력() {
        String[] inputs = {"1234", "12", "1", "12345"};
        for (String input : inputs) {
            assertThat(application.isValidInput(input)).isEqualTo(false);
        }
    }

    @Test
    void 서로_다른_수가_아닌_입력() {
        String[] inputs = {"111", "112", "121", "211"};
        for (String input : inputs) {
            assertThat(application.isValidInput(input)).isEqualTo(false);
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
