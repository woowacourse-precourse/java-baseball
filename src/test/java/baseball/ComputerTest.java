package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ComputerTest {

    @Test
    void 난수_생성_확인() {
        Computer computer = new Computer();

        computer.generateRandomNumber();

        assertThat(computer.getNumber()).isNotNull();
    }

    @Test
    void 난수가_세자리_인지_확인() {
        Computer computer = new Computer();

        computer.generateRandomNumber();

        assertThat(computer.getNumber()).hasSize(3);
    }
}