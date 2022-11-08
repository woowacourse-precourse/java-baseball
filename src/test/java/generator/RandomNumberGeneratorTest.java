package generator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.*;

public class RandomNumberGeneratorTest {
    @RepeatedTest(10)
    void ramdom_number_generator_test() {
        int randomNumber = RandomNumberGenerator.getNumber();
        assertThat(randomNumber)
                .isBetween(1, 9);
    }
}
