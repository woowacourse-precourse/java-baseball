package baseball.view;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputExceptionTest {
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void nullTest(String userInput) {
        assertThatThrownBy(()-> {
            InputException.nullException(userInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "1234"})
    public void userInputSizeTest(String userInput) {
        assertThatThrownBy(()-> {
            InputException.notNumberSizeException(userInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"r1", "1r", "rrr"})
    public void notGameNumberSizeTest(String userInput) {
        assertThatThrownBy(()-> {
            InputException.notGameNumberSizeException(userInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1R", "R1", "RR", "12R"})
    public void notNumberTest(String userInput) {
        assertThatThrownBy(()-> {
            InputException.notNumber(userInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0,3,4})
    public void notGameStatusTest(int userInput) {
        assertThatThrownBy(()-> {
            InputException.notGameStatusNumber(userInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }


}
