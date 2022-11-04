package model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ComputerTest {
    Computer computer = new Computer();

    @Test
    void 자동_생성_확인() {
        Integer result = 3;

        while (computer.getLengthOfNumber() < 3) {
            computer.generateRandomNumber();
        }
        System.out.println(computer.getComputerNumber());
        assertThat(computer.getLengthOfNumber()).isEqualTo(result);
    }
}
