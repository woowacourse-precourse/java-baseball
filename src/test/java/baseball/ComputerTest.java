package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComputerTest {

    private Computer computer;

    @BeforeEach
    public void setComputerClass() {
        computer = new Computer(3);
    }

    @Test
    void 진짜_난수인지() {
        for (int i = 0; i < 100; i++) {
            List<Character> characters = computer.makeRandomNum();
            assertThat(characters.get(0)).isNotEqualTo(characters.get(1));
            assertThat(characters.get(1)).isNotEqualTo(characters.get(2));
            assertThat(characters.get(0)).isNotEqualTo(characters.get(2));
        }
    }
}