package baseball.domain.wrapper;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BallNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    public void ballNumberExceptionTest(int number) throws Exception {
        assertThatThrownBy(() -> BallNumber.from(number))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 9})
    public void ballNumberPassTest(int number) throws Exception {
        assertDoesNotThrow(() -> BallNumber.from(number));
    }

}
