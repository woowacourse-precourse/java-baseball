package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
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
    void test_checkInputLength() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Application.checkInputLength("1", 3))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void test_checkInputInteger() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Application.checkInputInteger("1a*"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void test1_checkInputInteger() {
        List <Integer> result = Arrays.asList(1,2,3);
        assertSimpleTest(() ->
                assertThat(Application.checkInputInteger("123")).isEqualTo(result)
        );
    }

    @Test
    void test_checkInputDuplicate() {
        List <Integer> input = Arrays.asList(1,2,1);
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Application.checkInputDuplicate(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}