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
}
