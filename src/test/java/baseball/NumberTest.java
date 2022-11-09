package baseball;

import baseball.Model.Number;
import org.junit.jupiter.api.Test;

import org.assertj.core.api.Assertions;

public class NumberTest {

    private Number number = new Number();

    @Test
    void 숫자가_아닌_다른게_포함되면_예외발생() {
        Assertions.assertThatThrownBy(() -> {
            number.checkNumberAndSave("a12");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자가_아닌_다른게_포함되면_예외발생2() {
        Assertions.assertThatThrownBy(() -> {
                number.checkNumberAndSave("1 2");
            }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 길이가_3_아니면_예외발생() {
        Assertions.assertThatThrownBy(() -> {
            number.checkNumberAndSave("1234");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 길이가_3_아니면_예외발생2() {
        Assertions.assertThatThrownBy(() -> {
                number.checkNumberAndSave("12");
            }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복값이_있으면_예외발생() {
        Assertions.assertThatThrownBy(() -> {
            number.checkNumberAndSave("113");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 정상적인_입력() {
        Assertions.assertThat(number.checkNumberAndSave("159")).containsExactly(1,5,9);
        Assertions.assertThat(number.checkNumberAndSave("142")).containsExactly(1,4,2);
    }
}
