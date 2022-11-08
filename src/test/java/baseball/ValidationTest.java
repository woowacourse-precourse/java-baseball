package baseball;

import baseball.utils.Validation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidationTest {

    private static Validation validation;

    @BeforeEach
    public void beforeEach(){
        validation = new Validation();
    }


    @Test
    void 자릿수_초과입력_예외_테스트() {
        // given
        List<Integer> input = List.of(1,2);

        // when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> validation.validateLengthOfNumber(input));

        // then
        assertThat(e.getMessage()).isEqualTo("서로 다른 3자리의 수를 입력하세요.");
    }

    @Test
    void 자릿수_미만입력_예외_테스트() {
        // given
        List<Integer> input = List.of(1,2,3,4);

        // when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> validation.validateLengthOfNumber(input));

        // then
        assertThat(e.getMessage()).isEqualTo("서로 다른 3자리의 수를 입력하세요.");
    }

    @Test
    void 중복된_숫자_입력_예외_테스트() {
        // given
        List<Integer> input = List.of(2,2,3);

        // when
        Throwable throwable = catchThrowable(() -> validation.validateDuplicateNumber(input));

        // then
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자가_1과_9사이의_숫자가_아닌_입력_예외_테스트() {
        // given
        List<Integer> input = List.of(11,2,3);

        // when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> validation.validateNumberInRange(input));

        // then
        assertThat(e.getMessage()).isEqualTo("서로 다른 3자리의 수를 입력하세요.");
    }
}
