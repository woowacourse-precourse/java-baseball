package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

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
    void isValid_유효한_문자열이_입력() {
        String input = "792";
        boolean result = Application.isValid(input);
        assertThat(result).isEqualTo(true);
    }

    @Test
    void isValid_숫자가_3개가_아님() {
        String input1 = "1234";
        String input2 = "67";
        boolean result1 = Application.isValid(input1);
        boolean result2 = Application.isValid(input2);
        assertThat(result1).isEqualTo(false);
        assertThat(result2).isEqualTo(false);
    }

    @Test
    void isValid_숫자가_아닌_문자가_문자열에_포함() {
        String input = "1e3";
        boolean result = Application.isValid(input);
        assertThat(result).isEqualTo(false);
    }

    @Test
    void isValid_숫자에_0이_포함() {
        String input = "830";
        boolean result = Application.isValid(input);
        assertThat(result).isEqualTo(false);
    }

    @Test
    void isValid_중복되는_숫자가_존재() {
        String input = "363";
        boolean result = Application.isValid(input);
        assertThat(result).isEqualTo(false);
    }

    @Test
    void calculateResults_볼과_스트라이크() {
        ArrayList<Integer> targetNumbers = new ArrayList<>(Arrays.asList(3, 6, 9));
        ArrayList<Integer> playerNumbers = new ArrayList<>(Arrays.asList(9, 6, 3));
        ArrayList<Integer> result = Application.calculateResults(targetNumbers, playerNumbers);
        assertThat(result).containsExactly(2, 1);
    }

    @Test
    void calculateResults_일치하는_숫자_없음() {
        ArrayList<Integer> targetNumbers = new ArrayList<>(Arrays.asList(4, 6, 8));
        ArrayList<Integer> playerNumbers = new ArrayList<>(Arrays.asList(3, 5, 7));
        ArrayList<Integer> result = Application.calculateResults(targetNumbers, playerNumbers);
        assertThat(result).containsExactly(0, 0);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
