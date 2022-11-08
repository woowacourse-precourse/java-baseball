package baseball;

import baseball.model.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {
    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = new Validator();
    }

    @Test
    void 중복_존재() {
        List<Integer> input = List.of(1, 1, 2);
        assertThatThrownBy(() -> validator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 알파벳_포함() {
        List<Integer> input = List.of(1, 'a' - '0', 2);
        assertThatThrownBy(() -> validator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 세자리_이상() {
        List<Integer> input = List.of(1, 2, 3, 4);
        assertThatThrownBy(() -> validator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 세자리_미만() {
        List<Integer> input = List.of(1, 2);
        assertThatThrownBy(() -> validator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_0_포함() {
        List<Integer> input = List.of(0, 1, 2);
        assertThatThrownBy(() -> validator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
