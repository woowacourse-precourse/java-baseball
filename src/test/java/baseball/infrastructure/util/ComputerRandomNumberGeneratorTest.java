package baseball.infrastructure.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class ComputerRandomNumberGeneratorTest {

    @Test
    public void generateNumberSizeTest() throws Exception {
        List<Integer> generate = ComputerRandomNumberGenerator.generate();
        assertThat(generate.size()).isEqualTo(3);
    }

}
