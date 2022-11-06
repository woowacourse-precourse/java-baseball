package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.Application.createComputerNumber;
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
    void 컴퓨터수_범위_테스트() {
        //when
        List<Integer> computerNum = Application.createComputerNumber();
        //then
        assertThat(computerNum.stream().allMatch(v->1<=v && v<=9)).isTrue();
    }
    @Test
    void 컴퓨터수_서로다른수_테스트() {
        //given
        Set<Integer> numbers = new HashSet<>();
        //when
        List<Integer> computerNum = Application.createComputerNumber();
        computerNum.stream().
                forEach(v->numbers.add(v));
        //then
        assertThat(numbers.size()).isEqualTo(3);
    }
}
