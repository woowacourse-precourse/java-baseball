package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static baseball.Application.*;
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
    void 목표_숫자가_세자리_숫자인지_확인한다() {
        String num = generateGoalNumber();
        Assertions.assertThat(num.length()).isEqualTo(3);
    }

    @Test
    void 목표_숫자가_서로_다른_숫자로_이루어졌는지_확인한다() {
        String num = generateGoalNumber();
        Assertions.assertThat(num.charAt(0)).isNotEqualTo(num.charAt(1));
        Assertions.assertThat(num.charAt(0)).isNotEqualTo(num.charAt(2));
        Assertions.assertThat(num.charAt(1)).isNotEqualTo(num.charAt(2));
    }

    @Test
    void 사용자_입력은_세자리_숫자이다() {
        String num = "1248";
        Assertions.assertThat(isValidInput(num).equals(false));
    }

    @Test
    void 사용자_입력은_숫자이다() {
        String num = "abc";
        Assertions.assertThat(isValidInput(num).equals(false));
    }

    @Test
    void 사용자_입력은_서로_다른_숫자이다() {
        String num = "112";
        Assertions.assertThat(isValidInput(num).equals(false));
    }

    @Test
    void 모든_숫자가_일치하지_않으면_낫싱이다() {
        String targetNumber = "123";
        String userInput = "456";

        List<Integer> result = compareTwoNumbers(targetNumber, userInput);
        Assertions.assertThat(result.get(0).equals(0));
        Assertions.assertThat(result.get(1).equals(0));
    }

    @Test
    void 두개의_숫자가_다른_위치고_하나는_다르면_2볼이다() {
        String targetNumber = "123";
        String userInput = "931";

        List<Integer> result = compareTwoNumbers(targetNumber, userInput);
        Assertions.assertThat(result.get(0).equals(0));
        Assertions.assertThat(result.get(1).equals(2));
    }

    @Test
    void 하나가_위치까지_일치하고_둘이_서로_위치가_다르다() {
        String targetNumber = "123";
        String userInput = "132";

        List<Integer> result = compareTwoNumbers(targetNumber, userInput);
        Assertions.assertThat(result.get(0).equals(1));
        Assertions.assertThat(result.get(1).equals(2));
    }

    @Test
    void 목표와_입력이_같으면_스트라이크다() {
        String targetNumber = "369";
        String userInput = "369";

        List<Integer> result = compareTwoNumbers(targetNumber, userInput);
        Assertions.assertThat(result.get(0).equals(3));
        Assertions.assertThat(result.get(1).equals(0));
    }

    @Test
    void 쓰리스트라이크가_아니면_false다() {
        List<Integer> result = Arrays.asList(1, 2);
        Boolean isThreeSrikes = isThreeStrikes(result);

        Assertions.assertThat(isThreeSrikes).isEqualTo(false);
    }

    @Test
    void 쓰리스트라이크면_true다() {
        List<Integer> result = Arrays.asList(3, 0);
        Boolean isThreeSrikes = isThreeStrikes(result);

        Assertions.assertThat(isThreeSrikes).isEqualTo(true);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
