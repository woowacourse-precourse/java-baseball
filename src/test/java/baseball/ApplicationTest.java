package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    Application baseball = new Application();

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
    void 컴퓨터_숫자선택_중복값_사이즈_테스트() {
        List<Integer> test = baseball.SelectRandomNumbers();
        Set<Integer> testSet = new HashSet<>();
        for(int i : test) testSet.add(i);

        assertThat(testSet.size() == 3);
    }

    @Test
    void 입력값이_3자리인지_확인후_반환() {
        String input = "123";
        assertThat(baseball.isLengthThree(input));
    }

    @Test
    void 입력값이_3자리가_아닌_경우_예외_발생() {
        String input = "12";
        assertThatThrownBy(() -> baseball.isLengthThree(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력값의_범위가_1에서_9가_아닌_경우_예외_발생() {
        String input = "2a-";
        assertThatThrownBy(() -> baseball.isCorrectRange(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력값_중_중복된_숫자가_존재하는_경우_예외_발생() {
        String input = "221";
        assertThatThrownBy(() -> baseball.isEachOtherDifferent(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 같은_숫자가_같은_자리에_존재하는_경우의_수_반환() {
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> user = List.of(1, 2, 7);
        assertThat(baseball.CountingStrike(computer, user) == 2);
    }

    @Test
    void 같은_숫자가_다른_자리에_존재하는_경우의_수_반환() {
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> user = List.of(3, 4, 2);
        assertThat(baseball.CountingStrike(computer, user) == 2);
    }

    void 게임_종료_시_재시작_진행_동작_테스트() {
        int input = 1;
        assertThat();
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
