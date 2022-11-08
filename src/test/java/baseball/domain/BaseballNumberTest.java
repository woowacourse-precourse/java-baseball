package baseball.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BaseballNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 10, -1})
    void 잘못된_범위의_숫자_입력값_예외테스트(int ballNumber){
        assertThatThrownBy(() -> new BaseballNumber(ballNumber))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
