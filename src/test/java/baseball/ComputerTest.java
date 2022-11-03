package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ComputerTest {
    @Test
    void computerNumberListSizeEqualThree() {
        Computer computer = new Computer();

        assertThat(computer.computerNumberList.size()).isEqualTo(3);
    }

}