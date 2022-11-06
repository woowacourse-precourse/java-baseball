package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {

    @Test
    void computerConstructorTest() throws Exception {
        Computer computer = Computer.getComputer();

        for (int i = 0; i < 3; i++) {
            Number computerNumber = computer.findComputerNumber(i);
            assertThat(computerNumber).isInstanceOf(Number.class);
        }
    }

    @Test
    void computerDuplicateNumber() throws Exception {
        Computer computer = Computer.getComputer();

        for (int i = 0; i < 10000; i++) {
            computer.pickNewRandomNumbers();

            assertThat(computer.findComputerNumber(0).getNumber())
                    .isNotEqualTo(computer.findComputerNumber(1).getNumber());
            assertThat(computer.findComputerNumber(1).getNumber())
                    .isNotEqualTo(computer.findComputerNumber(2).getNumber());
            assertThat(computer.findComputerNumber(2).getNumber())
                    .isNotEqualTo(computer.findComputerNumber(0).getNumber());
        }
    }

}
