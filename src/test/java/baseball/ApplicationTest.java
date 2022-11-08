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
    void 숫자가_아닌_값_입력() {
        String input = "1a2";
        boolean result = false;
        assertThat(User.isNumberValidRange(input)).isEqualTo(result);
    }

    @Test
    void 길이가_초과한_값_입력() {
        String input = "1234";
        boolean result = false;
        assertThat(User.isNumberValidMaxSize(input)).isEqualTo(result);
    }

    @Test
    void 유효하지_않은_범위_내의_값_입력() {
        String input = "102";
        boolean result = false;
        assertThat(User.isNumberValidRange(input)).isEqualTo(result);
    }

    @Test
    void 입력값_숫자_변환_테스트() {
        String input = "123";
        List<Integer> result = List.of(1, 2, 3);
        assertThat(User.convertInputAsNumber(input)).isEqualTo(result);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
