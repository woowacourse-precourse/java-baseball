package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static baseball.Application.generateGoalNumber;
import static baseball.Application.isValidInput;
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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
