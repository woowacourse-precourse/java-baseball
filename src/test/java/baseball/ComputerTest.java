package baseball;


import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ComputerTest {

    @Test
    void computer_number_size_test() {
        //given
        Computer computer = new Computer();
        //when
        List<Integer> expected = computer.getComputerNumbersList();
        //then
        assertThat(expected.size()).isEqualTo(3);
    }

    @Test
    void computer_pick_unique_number_test() {
        //given
        Computer computer = new Computer();
        // when
        List<Integer> expected = computer.getComputerNumbersList();
        Set<Integer> actual = new HashSet<>(expected);
        //then
        assertThat(expected.size()).isEqualTo(actual.size());
    }


}
