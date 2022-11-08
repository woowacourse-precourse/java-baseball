package baseball.game;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComputerTest {

    private static final int LIST_SIZE = 3;

    private Computer computer;

    @BeforeEach
    public void setComputerClass() {
        computer = new Computer(LIST_SIZE);
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