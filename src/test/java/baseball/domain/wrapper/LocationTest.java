package baseball.domain.wrapper;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LocationTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 3})
    public void locationWrongNumberExceptionTest(int location) throws Exception {
        Assertions.assertThatThrownBy(() -> Location.from(location))
            .isInstanceOf(IllegalArgumentException.class);
    }

}
