package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

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
    void 서로_다른_임의의_수_3개_선택하여_저장하기() {
        List<Integer> numberList = new ArrayList<>();
        Application.makeRandomNumbers(numberList);
        Set<Integer> numberSet = new HashSet<>(numberList);
        assertThat(numberList).hasSameSizeAs(numberSet);
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
