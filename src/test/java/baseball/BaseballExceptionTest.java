package baseball;

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

        assertThat(exception.getMessage()).isEqualTo("입려된 값의 길이가 3이 아닙니다.");
    }
}
