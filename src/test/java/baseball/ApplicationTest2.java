package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationTest2 extends NsTest {

    // inputException()
    @Test
    void 예외_테스트_3개의_숫자가_아닌_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_서로_다른_3개의_숫자가_아닌_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("111"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // strikeInsepction()
    @Test
    void 스트라이크_점수_계산() {
        int input = 6;
        int computer = 6;
        assertEquals(Application.strikeInspection(input, computer), true);
        computer = 1;
        assertEquals(Application.strikeInspection(input, computer), false);
    }

    // ballCount()
    @Test
    void 볼_점수_계산() {
        String input = "123";
        List<Integer> computer = List.of(1, 3, 5);
        assertEquals(1, Application.ballCount(input, computer));
    }

    // outputFormat()
    @Test
    void 게임결과_출력_형식() {
        int strike = 1;
        int ball = 2;
        assertEquals("2볼 1스트라이크", Application.outputFormat(strike, ball));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}