package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
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

    @Nested
    class ComputerTest {
        Computer computer = new Computer();
        @Test
        void 컴퓨터_숫자_3자리인지_테스트() {
            //given
            List<Integer> numberList = computer.getRandomNumber();
            //then
            assertThat(3).isEqualTo((numberList.size()));

        }

        @Test
        void 컴퓨터_숫자_중복없는지_테스트() {
            //given
            List<Integer> numberList = computer.getRandomNumber();
            //when
            Set<Integer> numberSet = new HashSet<>(numberList);
            //then
            assertThat(3).isEqualTo((numberSet.size()));

        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
