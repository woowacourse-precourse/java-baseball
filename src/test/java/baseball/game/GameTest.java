package baseball.game;

import baseball.computer.Computer;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class GameTest {
    @Test
    public void prepare_Computer_Test(){
        Computer computer = new Computer();
        computer.createRandomNumbers();
        assertThat(computer.getDigits()).isNotEmpty();
    }
}
