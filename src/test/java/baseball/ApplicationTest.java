package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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

    /* Random number Test */
    @Test
    void randomArrayListSizeTest() {
        Application test = new Application();
        ArrayList<Integer> result = test.settingNumber();
        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    void randomArrayListOverlapTest() {
        Application test = new Application();
        ArrayList<Integer> numList = test.settingNumber();
        Set<Integer> numSet = new HashSet<>(numList);
        assertThat(numList.size()).isEqualTo(numSet.size());
    }

    /* Get Number Test */
    @Test
    void getNumberOverlapCheckTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("121"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void getNumberStringCheckTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1ab"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
