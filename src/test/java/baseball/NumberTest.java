package baseball;

import baseball.Model.Number;
import org.junit.jupiter.api.Test;

import org.assertj.core.api.Assertions;

public class NumberTest {

    private Number number = new Number();

    @Test
    void 정상적인_입력() {
        Assertions.assertThat(number.createUserNumber("159")).containsExactly(1,5,9);
        Assertions.assertThat(number.createUserNumber("142")).containsExactly(1,4,2);
    }
}
