package baseball.model;

import baseball.model.BaseballNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class BaseballNumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"hi!", "12a", "1bb"})
    void 숫자가_아닌_다른값_입력(String input){
        assertThatThrownBy(() -> new BaseballNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"111", "221"})
    void 중복_숫자_입력(String input){
        assertThatThrownBy(() -> new BaseballNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 정상_숫자_성공() {
        assertThatNoException().isThrownBy(() -> new BaseballNumber("123"));
    }
}
