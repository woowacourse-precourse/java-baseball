package baseball;

import baseball.exception.InputException;
import baseball.util.Util;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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

    /*
    형 변환 테스트코드
     */

    @Test
    public void 문자를_숫자_리스트로_변경() {
        String inputNumbers = "123";
        List<Integer> result = Arrays.asList(1, 2, 3);

        assertThat(result).isEqualTo(Util.toList(inputNumbers));
    }

    /*
    예외 테스트코드
     */

    @Test
    public void 입력한_문자가_숫자가_아니라면_예외_발생() {
        String input = "54f";

        assertThatThrownBy(() -> InputException.isNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자가 아닙니다.");
    }

    @Test
    public void 입력한_숫자의_길이가_3이상이라면_예외_처리() {
        String number = "23325";

        assertThatThrownBy(() -> InputException.isLength(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자의 길이가 맞지 않습니다.");
    }

    @Test
    public void 입력한_숫자들중_중복된_숫자가_있다면_예외_처리() {
        String number = "133";

        assertThatThrownBy(() -> InputException.isDuplicate(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 숫자가 있습니다.");
    }

    @Test
    public void 게임_재시작_여부_입력_형식이_맞지_않다면_예외_처리() {
        String resetNumber = "4";

        assertThatThrownBy(() -> InputException.isResetNumberFormat(resetNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("재시작 여부 입력 형식이 맞지 않습니다.");
    }
}
