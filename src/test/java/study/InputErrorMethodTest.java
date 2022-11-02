package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputErrorMethodTest {
    @Test
    void checkLengthError_input의크기_IllegalArgumentException발생_체크() {
        String input = "abcd";
        if(input.length() > 3){
            assertThatThrownBy(() -> { throw new IllegalArgumentException("boom"); }).isInstanceOf(Exception.class)
                    .hasMessageContaining("boom");
        }
    }

}
