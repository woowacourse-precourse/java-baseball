package baseball.validation;

import static baseball.util.Constant.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidationTest {

    private Validation validation = new Validation();

    @Test
    void 플레이어가_제시한_숫자의_길이가_3인지_검증하는_기능_true반환_테스트() {
        String answer = "123";

        assertThat(validation.checkAnswerLength(answer)).isEqualTo(true);
    }

    @Test
    void 플레이어가_제시한_숫자의_길이가_3인지_검증하는_기능_false반환_테스트() {
        String answer = "1234";

        assertThat(validation.checkAnswerLength(answer)).isEqualTo(false);
    }

    @Test
    void 플레이어가_제시한_숫자가_1부터_9사이의_수로_구성되어있는지_검증하는_기능_true반환_테스트() {
        String answer = "123";

        assertThat(validation.checkAnswerConsistOfNum(answer)).isEqualTo(true);
    }

    @Test
    void 플레이어가_제시한_숫자가_1부터_9사이의_수로_구성되어있는지_검증하는_기능_false반환_테스트() {
        String answer = "012";

        assertThat(validation.checkAnswerConsistOfNum(answer)).isEqualTo(false);
    }

    @Test
    void 플레이어가_제시한_숫자가_서로_다른_숫자로_구성되어있는지_검증하는_기능_true반환_테스트() {
        String answer = "123";

        assertThat(validation.checkAnswerOverlap(answer)).isEqualTo(true);
    }

    @Test
    void 플레이어가_제시한_숫자가_서로_다른_숫자로_구성되어있는지_검증하는_기능_false반환_테스트() {
        String answer = "121";

        assertThat(validation.checkAnswerOverlap(answer)).isEqualTo(false);
    }


    @Test
    void 플레이어가_제시한_숫자에_대해_통합으로_검증_기능_숫자길이_오류_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> validation.checkAnswerValidation("1234"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_LENGTH_THREE)
        );
    }

    @Test
    void 플레이어가_제시한_숫자에_대해_통합으로_기능_숫자구성_오류_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> validation.checkAnswerValidation("ㄱ12"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_CONSIST_OF_NUM)
        );
    }

    @Test
    void 플레이어가_제시한_숫자에_대해_통합으로_검증_기능_중복_숫자_오류_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> validation.checkAnswerValidation("112"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_OVERLAP_NUM)
        );
    }

    @Test
    void 게임을_재시작_및_종료하는_플레이어의_응답을_검증하는_기능_오류_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> validation.checkRestartOrExitValidation("3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_INPUT)
        );
    }
}