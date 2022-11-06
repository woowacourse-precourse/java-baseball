package baseball;

import baseball.Model.Number;
import org.junit.jupiter.api.Test;

import org.assertj.core.api.Assertions;

public class NumberTest {

    private Number number = new Number();

    @Test
    void 숫자가_아닌_다른게_포함되면_예외발생() {
        Assertions.assertThatThrownBy(() -> {
            number.createUserNumber("a12");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자가_아닌_다른게_포함되면_예외발생2() {
        Assertions.assertThatThrownBy(() -> {
                number.createUserNumber("1 2");
            }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 길이가_3_아니면_예외발생() {
        Assertions.assertThatThrownBy(() -> {
            number.createUserNumber("1234");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 길이가_3_아니면_예외발생2() {
        Assertions.assertThatThrownBy(() -> {
                number.createUserNumber("12");
            }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 정상적인_입력() {
        Assertions.assertThat(number.createUserNumber("159")).containsExactly(1,5,9);
        Assertions.assertThat(number.createUserNumber("142")).containsExactly(1,4,2);
    }
}
