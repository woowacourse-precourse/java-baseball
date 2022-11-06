package generator;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGeneratorTest {
    @RepeatedTest(10)
    void ramdom_number_generator_test() {
        int randomNumber = RandomNumberGenerator.getNumber();
        assertThat(randomNumber)
                .isBetween(1, 9);
    }
}
