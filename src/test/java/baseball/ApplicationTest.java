package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void listNumber1() {
        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9);
        assertThat(Application.removeRepetitionNumber(list)).isEqualTo(123);
    }

    @Test
    void listNumber2() {
        List<Integer> list = List.of(1,2,2,2,2,2,2,2,2,3);
        assertThat(Application.removeRepetitionNumber(list)).isEqualTo(123);
    }

    @Test
    void listNumber3() {
        List<Integer> list = List.of(1,1,2,2,3,4,5);
        assertThat(Application.removeRepetitionNumber(list)).isEqualTo(123);

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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
