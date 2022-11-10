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
    void 각_자리가_모두_다른_세_자리_수_생성() {
        List<Integer> targetNumber = Application.createTargetNumber();
        int hundreds = targetNumber.get(0);
        int tens = targetNumber.get(1);
        int ones = targetNumber.get(2);

        assertThat(hundreds).isNotEqualTo(tens).isNotEqualTo(ones);
    }

    @Test
    void 네_자리의_수_입력에_대해_예외_발생() {
        String input = "1234";

        assertThatThrownBy(() -> Application.validateGuessedNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자가_아닌_입력에_대해_예외_발생() {
        String input = "abc";

        assertThatThrownBy(() -> Application.validateGuessedNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void printResult_메서드_결과_확인() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("456", "321", "132", "987", "123", "2");
                    assertThat(output()).
                            contains("낫싱", "2볼 1스트라이크", "2볼 1스트라이크", "낫싱", "3스트라이크", "게임 종료");
                },
                1, 2, 3
        );
    }

    @Test
    void 중복되는_숫자_입력_에러_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("122"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 재시작_여부_예외_입력_에러_발생() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("123", "3")).isInstanceOf(IllegalArgumentException.class);
                },
                1, 2, 3
        );
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
