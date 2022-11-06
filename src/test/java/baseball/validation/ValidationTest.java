package baseball.validation;

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

}