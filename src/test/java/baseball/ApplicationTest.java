package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

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

    @Test
    void 랜덤_숫자_테스트1_3자리_수() {
        List<Integer> randomNum = Application.createRandomNum();
        Assertions.assertThat(randomNum.size()).isSameAs(3);
    }

    @Test
    void 랜덤_숫자_테스트2_중복_숫자() {
        List<Integer> randomNumList = Application.createRandomNum();
        Set<Integer> randomNumSet = new HashSet<>(randomNumList);
        Assertions.assertThat(randomNumList.size()).isSameAs(randomNumSet.size());
    }

    @Test
    void 랜덤_숫자_테스트3_각_원소의_숫자_범위_0_9() {
        List<Integer> randomNum = Application.createRandomNum();
        for (Integer x : randomNum) {
            assertThat(x).isLessThan(10).isGreaterThan(0);
        }
    }

    @Test
    void 볼_스트라이크_테스트() {
        String checkNumAnswer = Application.checkNum("356", "345");
        Assertions.assertThat(checkNumAnswer).isEqualTo("1볼 1스트라이크");
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
