package baseball.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidateNumberServiceTest {

    ValidateNumberService validateNumberService = new ValidateNumberService();


    @Test
    void 숫자_이외의_문자포함_검증() {
        Assertions.assertThatThrownBy(() -> validateNumberService.validateUserInput("12a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복_숫자_검증() {
        Assertions.assertThatThrownBy(() -> validateNumberService.validateUserInput("121"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 길이_검증() {
        Assertions.assertThatThrownBy(() -> validateNumberService.validateUserInput("12345"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}