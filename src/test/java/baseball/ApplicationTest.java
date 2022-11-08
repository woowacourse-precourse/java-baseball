package baseball;

import baseball.exception.IllegalSizeException;
import baseball.exception.InputDuplicationException;
import baseball.exception.OutOfRangeException;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 입력값_갯수_유효성_검증() {
        String input = "1234";

        assertThrows(IllegalSizeException.EXCEPTION.getClass(),
            () -> run(input));
    }

    @Test
    void 입력값_범위_유효성_검증() {
        String input = "902";

        assertThrows(OutOfRangeException.EXCEPTION.getClass(),
            () -> run(input));
    }

    @Test
    void 입력값_중복_유효성_검증() {
        String input = "233";

        assertThrows(InputDuplicationException.EXCEPTION.getClass(),
            () -> run(input));
    }
}
