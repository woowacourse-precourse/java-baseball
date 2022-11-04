package model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ComputerTest {

    @Test
    void 자동_생성_확인() {
        Integer result = 3;

        while (Computer.getLengthOfNumber() < 3) {
            Computer.generateRandomNumber();
        }

        assertThat(Computer.getLengthOfNumber()).isEqualTo(result);
    }
}
