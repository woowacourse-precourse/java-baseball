package custom;

import baseball.domain.Validator;
import baseball.domain.game.baseball.CreateBaseBall;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CustomTest {
    CreateBaseBall game = new CreateBaseBall();

    @Test
    void validatorRandomNumber() {
        String randomNumber = game.generateRandomNumber();
        String comparedRandomNumber = game.generateRandomNumber();
        assertThat(randomNumber).isNotEqualTo(comparedRandomNumber);
    }

    @Test
    void 세자리_넘어가는_숫자를_입력한_경우_예외를_반환() {
        Validator validator= new Validator();
        String input = "1234";

        assertThatThrownBy(() -> validator.validateRandomNumberExceedLength(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("세자리 숫자만 입력해주세요");
    }

    @Test
    void 문자를_포함하여_입력한_경우_예외를_반환() {
        Validator validator= new Validator();
        String input = "a12";

        assertThatThrownBy(() -> validator.validateContainChar(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("세자리 숫자만 입력해주세요");
    }

    @Test
    void 공백을_포함하여_입력한_경우_예외를_반환() {
        Validator validator= new Validator();
        String input = "1 23";

        assertThatThrownBy(() -> validator.validateContainBlank(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("세자리 숫자만 입력해주세요");
    }

    @Test
    void 영을_포함하여_입력한_경우_예외를_반환() {
        Validator validator= new Validator();
        String input = "103";

        assertThatThrownBy(() -> validator.validateContainZero(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 랜덤_숫자_크기가_3인지_확인() {
        String randomNumber = game.generateRandomNumber();
        assertThat(randomNumber).hasSize(3);
    }
}
