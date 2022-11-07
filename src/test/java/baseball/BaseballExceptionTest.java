package baseball;

import constant.GameConstant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballExceptionTest {

    @Test
    void 사용자_입력_길이_예외처리_테스트(){
        String input = "1234";

        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            BaseballException.InputLengthException(input);
        });

        assertThat(exception.getMessage()).isEqualTo(GameConstant.INPUT_LENGTH_EXCEPTION);
    }
    
    @Test
    void 사용자_숫자외_입력_예외처리_테스트_숫자외() {
        String input = "a12";

        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            BaseballException.InputTypeBoundaryException(input);
        });

        assertThat(exception.getMessage()).isEqualTo(GameConstant.INPUT_TYPE_EXCEPTION);
    }

    @Test
    void 사용자_숫자외_입력_예외처리_테스트_범위외() {
        String input = "012";

        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            BaseballException.InputTypeBoundaryException(input);
        });

        assertThat(exception.getMessage()).isEqualTo(GameConstant.INPUT_BOUNDARY_EXCEPTION);
    }

    @Test
    void 사용자_중복_숫자_입력_예외처리_테스트() {
        String input = "131";

        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            BaseballException.InputRepeatException(input);
        });

        assertThat(exception.getMessage()).isEqualTo(GameConstant.INPUT_REPEAT_EXCEPTION);
    }
}
