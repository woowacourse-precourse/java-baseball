package baseball.infrastructure.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import baseball.domain.ConsoleInString;
import java.util.List;
import org.junit.jupiter.api.Test;

class GamerInputNumberGeneratorTest {

    @Test
    public void isNotNumberStringExceptionTest() throws Exception {
        ConsoleInString string = () -> "abc";
        assertThatThrownBy(() -> GamerInputNumberGenerator.generator(string))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void isNumberStringTest() throws Exception {
        ConsoleInString string = () -> "123";
        assertDoesNotThrow(() -> GamerInputNumberGenerator.generator(string));
    }

    @Test
    public void generateListTest() throws Exception {
        List<Integer> integers = List.of(1, 2, 3);
        ConsoleInString string = () -> "123";
        assertThat(GamerInputNumberGenerator.generator(string)).isEqualTo(integers);
    }
}
