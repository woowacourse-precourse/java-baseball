package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ComputerTest {
    Computer computer = new Computer();

    @Test
    void 컴퓨터_수_길이() {
        assertThat(computer.computerNumber().size()).isEqualTo(3);
    }

    @Test
    void 컴퓨터_수_중복() {
        assertThat(computer.computerNumber().stream().distinct()).isEqualTo(computer.computerNumber());
    }

}
