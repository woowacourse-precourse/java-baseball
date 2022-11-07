package baseball;

import baseball.model.Computer;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ComputerTest {
    @Test
    void generateRandomTest() {
        Computer computer = new Computer();

        String computerBall = computer.getBall();
        assertThat(computerBall).hasSize(3);
        assertThat(Character.getNumericValue(computerBall.charAt(0))).isBetween(0, 9);
        assertThat(Character.getNumericValue(computerBall.charAt(1))).isBetween(0, 9);
        assertThat(Character.getNumericValue(computerBall.charAt(2))).isBetween(0, 9);
    }
}