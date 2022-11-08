package baseball.game;

import baseball.computer.Computer;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrepareComputerTest {
    static Computer computer = new Computer();
    @Test
    public void prepare_Computer_Test(){
        computer.createRandomNumbers();
        assertThat(computer.getDigits()).isNotEmpty();
    }
}
