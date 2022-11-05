package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.Computer.RAND_NUM_MAX;
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
    public void 임의의_수가_3개인지_테스트() {
        Computer computer = new Computer();
        List<Integer> number = computer.createRandomNumber();
        assertThat(number.size()).isEqualTo(3);
    }

    @Test
    public void 임의의_수가_서로_다른_숫자인지_테스트() {
        Computer computer = new Computer();
        List<Integer> before_number = computer.createRandomNumber();
        Set<Integer> after_number = new HashSet<>(before_number);
        assertThat(after_number.size()).isEqualTo(before_number.size());
    }

    @Test
    public void 임의의_3자리_숫자의_범위_테스트() {
        Computer computer = new Computer();
        List<Integer> number = computer.createRandomNumber();
        List<Integer> range = Arrays.asList(1,2,3,4,5,6,7,8,9);

        for(int numberIndex = 0; numberIndex < RAND_NUM_MAX; numberIndex++) {
            assertThat(range).contains(number.get(numberIndex));
        }
    }
}
