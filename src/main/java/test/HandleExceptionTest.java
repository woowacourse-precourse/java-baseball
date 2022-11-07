package test;

import controller.Controller;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class HandleExceptionTest {

    @Test
    void 예외처리_발생() {
        assertThatThrownBy(() -> Controller.handleException(false))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatCode(() -> Controller.handleException(true))
                .doesNotThrowAnyException();
    }

}
