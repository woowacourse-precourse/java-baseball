package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static baseball.Application.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
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
    void 랜덤_세자리_숫자_길이_테스트() {
        List<Integer> result = new ArrayList<>(Arrays.asList(1, 2, 3));

        assertThat(result.size()).isEqualTo(makeRandomBall().size());
    }

    @Test
    void 문자가_숫자로_변환되었는지_테스트() {
        String input = "123";
        Integer result = 1;

        assertThat(getStringToIntList(input).get(0)).isEqualTo(result);
    }

    @Test
    void compareBall_에서_낫싱_반환_테스트() {
        List<Integer> computerBall = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> userBall = new ArrayList<>(Arrays.asList(4, 5, 6));

        String result = "낫싱";

        assertThat(compareBall(computerBall, userBall)).isEqualTo(result);
    }

    @Test
    void compareBall_에서_2볼_1스크라이크_반환_테스트() {
        List<Integer> computerBall = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> userBall = new ArrayList<>(Arrays.asList(2, 1, 3));

        String result = "2볼 1스트라이크";

        assertThat(compareBall(computerBall, userBall)).isEqualTo(result);
    }

    @Test
    void compareBall_에서_3스크라이크_반환_테스트() {
        List<Integer> computerBall = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> userBall = new ArrayList<>(Arrays.asList(1, 2, 3));

        String result = "3스트라이크";

        assertThat(compareBall(computerBall, userBall)).isEqualTo(result);
    }

    @Test
    void compareBall_에서_3볼_반환_테스트() {
        List<Integer> computerBall = new ArrayList<>(Arrays.asList(3, 1, 2));
        List<Integer> userBall = new ArrayList<>(Arrays.asList(1, 2, 3));

        String result = "3볼";

        assertThat(compareBall(computerBall, userBall)).isEqualTo(result);
    }

    @Test
    void compareBall_에서_1볼_1스크라이크_반환_테스트() {
        List<Integer> computerBall = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> userBall = new ArrayList<>(Arrays.asList(1, 7, 2));

        String result = "1볼 1스트라이크";

        assertThat(compareBall(computerBall, userBall)).isEqualTo(result);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
