package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

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
    void 입력_갯수_유효성_검증_테스트() {
        List<Integer> input = new ArrayList<>();
        input.add(8);
        assertThatThrownBy(() -> Game.isValid(input))
                .isInstanceOf(IllegalArgumentException.class);
        input.add(8);
        input.add(8);
        input.add(8);
        assertThatThrownBy(() -> Game.isValid(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복_검사_유효성_검증_테스트() {
        List<Integer> input = new ArrayList<>();
        input.add(8);
        input.add(8);
        input.add(8);
        assertThatThrownBy(() -> Game.isValid(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력_유효성_검증_테스트() {
        List<Integer> input = new ArrayList<>();
        input.add(8);
        input.add(0);
        input.add(8);
        assertThatThrownBy(() -> Game.isValid(input))
                .isInstanceOf(IllegalArgumentException.class);
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
}
