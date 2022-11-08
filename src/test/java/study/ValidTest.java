package study;

import org.junit.jupiter.api.Test;

import static baseball.valid.Valid.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidTest {
    @Test
    void validUserInputSize_메소드_예외_체크(){
        assertThatThrownBy(() -> validUserInputSize("1234"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3자리 수를 입력해야 합니다");
    }

    @Test
    void validUserInputNotNumber_메소드_예외_체크(){
        assertThatThrownBy(() -> validUserInputNotNumber("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자가 아닌 문자가 입력되었습니다.");
    }

    @Test
    void validDuplicateNumber_메소드_예외_체크(){
        assertThatThrownBy(() -> validDuplicateNumber("122"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 숫자가 입력되었습니다");
    }
}
