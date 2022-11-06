package baseball.game;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ComputerNumberTest {

    @Test
    void createComputerNumber_0미포함() {
        assertThat(ComputerNumber.createComputerNumber()).doesNotContain(0);
    }

    @Test
    void createComputerNumber_3개() {
        assertThat(ComputerNumber.createComputerNumber().size()).isEqualTo(3);
    }
}