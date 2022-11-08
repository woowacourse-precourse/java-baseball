package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {

    @Test
    void 중복값_검사() {
        Computer computer = new Computer();
        computer.selectUniqueNumbers();

        List<Integer> computerNumberList = computer.getComputer();
        Set<Integer> computerNumberSet = Set.copyOf(computerNumberList);

        assertThat(computerNumberList.size()).isEqualTo(computerNumberSet.size());
    }
}