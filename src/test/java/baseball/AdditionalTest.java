package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AdditionalTest extends NsTest {
    @Test
    void checkNonNumbers_함수_테스트() {
        String input = "12a";
        boolean result = true;

        assertThat(result).isEqualTo(Application.checkNonNumbers(input));
    }

    @Test
    void checkRepeatNumber_함수_테스트() {
        String input = "122";
        boolean result = true;

        assertThat(result).isEqualTo(Application.checkRepeatNumber(input));
    }

    @Test
    void validateGameInput_함수_테스트1() {
        String input = "5678";
        boolean result = false;

        assertThat(result).isEqualTo(Application.validateGameInput(input));
    }

    @Test
    void validateGameInput_함수_테스트2() {
        String input = "908";
        boolean result = false;

        assertThat(result).isEqualTo(Application.validateGameInput(input));
    }

    @Test
    void validateGameInput_함수_테스트3() {
        String input = "1v4";
        boolean result = false;

        assertThat(result).isEqualTo(Application.validateGameInput(input));
    }

    @Test
    void validateGameInput_함수_테스트4() {
        String input = "334";
        boolean result = false;

        assertThat(result).isEqualTo(Application.validateGameInput(input));
    }

    @Test
    void 예외_테스트1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("890"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("x98"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("455"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void convertInputToList_함수_테스트() {
        String input = "145";
        List<Integer> result = List.of(1, 4, 5);

        assertThat(result).isEqualTo(Application.convertInputToList(input));
    }

    @Test
    void checkBallStrike_함수_테스트1() {
        List<Integer> gameAnswer = List.of(9, 5, 7);
        List<Integer> userAnswer = List.of(4, 5, 9);
        boolean result = false;

        assertThat(result).isEqualTo(Application.checkBallStrike(gameAnswer, userAnswer));
    }

    @Test
    void checkBallStrike_함수_테스트2() {
        List<Integer> gameAnswer = List.of(3, 8, 4);
        List<Integer> userAnswer = List.of(3, 8, 4);
        boolean result = true;

        assertThat(result).isEqualTo(Application.checkBallStrike(gameAnswer, userAnswer));
    }

    @Test
    void checkRestart_함수_테스트1() {
        String input = "1";
        boolean result = true;

        assertThat(result).isEqualTo(Application.checkRestart(input));
    }

    @Test
    void checkRestart_함수_테스트2() {
        String input = "2";
        boolean result = false;

        assertThat(result).isEqualTo(Application.checkRestart(input));
    }

    @Test
    void checkRestart_함수_테스트3() {
        String input = "3";

        assertThatThrownBy(() -> Application.checkRestart(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

