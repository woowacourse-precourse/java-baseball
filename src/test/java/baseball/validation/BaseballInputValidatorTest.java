package baseball.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class BaseballInputValidatorTest {

    Validator<List<Integer>> validator = new BaseballInputValidator();

    @Test
    public void validateSize() {
        //given
        List<Integer> target1 = List.of(1, 2, 3, 4);
        List<Integer> target2 = List.of(1, 2, 3);

        //when
        boolean result1 = validator.validate(target1);
        boolean result2 = validator.validate(target2);

        //then
        Assertions.assertThat(result1).isFalse();
        Assertions.assertThat(result2).isTrue();
    }

    @Test
    public void validateRange() {
        //given
        List<Integer> target1 = List.of(0, 5, 6);
        List<Integer> target2 = List.of(5, 6, 10);
        List<Integer> target3 = List.of(1, 2, 3);
        List<Integer> target4 = List.of(7, 8, 9);

        //when
        boolean result1 = validator.validate(target1);
        boolean result2 = validator.validate(target2);
        boolean result3 = validator.validate(target3);
        boolean result4 = validator.validate(target4);

        //then
        Assertions.assertThat(result1).isFalse();
        Assertions.assertThat(result2).isFalse();
        Assertions.assertThat(result3).isTrue();
        Assertions.assertThat(result4).isTrue();
    }

    @Test
    public void validateDup() {
        //given
        List<Integer> target1 = List.of(2, 2, 3);
        List<Integer> target2 = List.of(2, 2, 2);
        List<Integer> target3 = List.of(1, 2, 3);

        //when
        boolean result1 = validator.validate(target1);
        boolean result2 = validator.validate(target2);
        boolean result3 = validator.validate(target3);

        //then
        Assertions.assertThat(result1).isFalse();
        Assertions.assertThat(result2).isFalse();
        Assertions.assertThat(result3).isTrue();
    }
}