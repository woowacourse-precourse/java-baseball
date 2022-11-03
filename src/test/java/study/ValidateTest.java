package study;

import baseball.Validate;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

public class ValidateTest {

    @Test
    void 길이_3초과면_예외발생() {
        List<Integer> numbers = List.of(1, 2, 3, 4);
        assertThatThrownBy(() -> Validate.check(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복되면_예외발생() {
        List<Integer> numbers = List.of(1, 1, 1);
        assertThatThrownBy(() -> Validate.check(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자에_0이_포함되면_예외발생() {
        List<Integer> numbers = List.of(1, 0, 3);
        assertThatThrownBy(() -> Validate.check(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
