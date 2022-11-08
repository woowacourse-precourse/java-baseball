package baseball.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class PlayerInputValidatorTest {
    PlayerInputValidator playerInputValidator = new PlayerInputValidator();

    @Test
    void 사용자_입력이_유효성_검사를_통과하면_리스트반환() {
        assertThat(playerInputValidator.validatePlayerAnswerInput("451"))
                .isEqualTo(List.of(4, 5, 1));
    }

    @Test
    void 사용자가_입력한_정답이_세글자가_아니면_예외발생() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> playerInputValidator.validatePlayerAnswerInput("1234"));
    }

    @Test
    void 사용자가_입력한_정답에_문자가_있다면_예외발생() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> playerInputValidator.validatePlayerAnswerInput("12"));
    }

    @Test
    void 사용자가_입력한_정답에_중복숫자가_있으면_예외발생() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> playerInputValidator.validatePlayerAnswerInput("313"));
    }
}