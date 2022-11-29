package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest extends NsTest {

    @DisplayName("한 세트진행중 플레이어가 입력한 숫자 검증")
    @ParameterizedTest
    @ValueSource(strings = {"1234", "   ", "3  ", "  4"})
    void numberInputTest(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("한 세트후 플레이어의 리플레이 의사여부 입력값 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"11", "22", " ", " 1", " 2", "aa", "12"})
    void replayCommandInputTest(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> assertRandomNumberInRangeTest(
                        () -> run("321", "123", input), 1, 2, 3))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
