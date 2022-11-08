package baseball;

import baseball.result.ResultValidator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ResultValidatorTest {
    static final int STRIKE = 0;
    static final int BALL = 1;
    @Test
    void case1() {
        ResultValidator resultValidator = new ResultValidator();

        List<Integer> res = resultValidator.validate("123","123");

        assertThat(res.get(STRIKE)).isEqualTo(3);
        assertThat(res.get(BALL)).isEqualTo(0);
    }

    @Test
    void case2() {
        ResultValidator resultValidator = new ResultValidator();

        List<Integer> res = resultValidator.validate("679","697");

        assertThat(res.get(STRIKE)).isEqualTo(1);
        assertThat(res.get(BALL)).isEqualTo(2);
    }

    @Test
    void case3() {
        ResultValidator resultValidator = new ResultValidator();

        List<Integer> res = resultValidator.validate("247","279");

        assertThat(res.get(STRIKE)).isEqualTo(1);
        assertThat(res.get(BALL)).isEqualTo(1);
    }

}
