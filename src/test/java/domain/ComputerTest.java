package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {

    Computer computer = new Computer();

    @Test
    @DisplayName("컴퓨터의 랜덤 수 만들기")
    void testCreateRandomNumbers() {
        computer.createRandomNumbers();

        assertThat(computer.getNumbers()).hasSize(3);
    }

    @Test
    @DisplayName("컴퓨터의 랜덤 수 초기화")
    void testInit() {
        computer.createRandomNumbers();
        computer.init();

        assertThat(computer.getNumbers()).isEmpty();
    }

}
