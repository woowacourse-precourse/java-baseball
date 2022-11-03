package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {

    @Test
    void computerConstructorTest() throws Exception {
        Computer computer = new Computer();

        for (int i = 0; i < 3; i++) {
            Number computerNumber = computer.findComputerNumber(i);
            assertThat(computerNumber).isInstanceOf(Number.class);
        }
    }
}
