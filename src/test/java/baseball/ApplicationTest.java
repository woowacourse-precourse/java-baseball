package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

import static baseball.Application.generateNumber;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        //6회 게임 연속 진행시 정상 작동 확인
    void 게임종료_후_재시작2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("123", "1", "123", "1", "123", "1", "123", "1", "123", "1", "123", "2");
                    assertThat(output()).contains("3스트라이크", "3스트라이크", "3스트라이크", "3스트라이크","3스트라이크","3스트라이크", "게임 종료");
                },
                1,
                2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234","1","23","55555","우테코","wooTeco"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void test_generateNumber() {
        List<Integer> result = generateNumber();
        Set<Integer> setResult = new HashSet<>(result);

        assertEquals(result.size(),3);
        assertEquals(setResult.size(),3);
    }
    @Test
    void test_countStrike2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("145", "124", "123", "2");
                    assertThat(output()).contains("1스트라이크", "2스트라이크", "3스트라이크", "게임 종료");
                },
                1,
                2, 3
        );
    }
    @Test
    void test_nothingCount() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("456", "567", "789", "123", "2");
                    assertThat(output()).contains("낫싱", "낫싱", "낫싱", "3스트라이크", "게임 종료");
                },
                1,
                2, 3
        );
    }

    @Test
    void test_ballCount() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("245", "234", "231", "123", "2");
                    assertThat(output()).contains("1볼", "2볼", "3볼", "3스트라이크", "게임 종료");
                },
                1,
                2, 3
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
