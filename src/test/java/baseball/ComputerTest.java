package baseball;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.List;


class ComputerTest {

    @Test
    void 올바른_입력() {
        Computer computer = new Computer();
        List<Integer> nums = computer.createNums(3);
        assertThat(new HashSet<>(nums)).hasSize(3);
    }

}