package baseball.exception;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class InputExceptionTest {

    @Test
    void containsNonDigit() {
        String normal = "123";
        String nonDigit = "4ab";
        String space = "1 3";

        Boolean bool1 = InputException.containsNonDigit(normal);
        Boolean bool2 = InputException.containsNonDigit(nonDigit);
        Boolean bool3 = InputException.containsNonDigit(space);

        assertThat(bool1).isFalse();
        assertThat(bool2).isTrue();
        assertThat(bool3).isTrue();


    }
}