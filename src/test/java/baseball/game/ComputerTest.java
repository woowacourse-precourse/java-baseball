package baseball.game;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComputerTest {
    Computer computer;

    @BeforeEach
    void setUp() {
        computer = new Computer();
    }

    @Test
    void 컴퓨터가_생성한_숫자는_3자리_여야한다() {
        computer.generateNumbers();
        List<Integer> numbers = computer.getNumbers();
        Assertions.assertThat(numbers.size())
                .isEqualTo(3);
    }

    @Test
    void 컴퓨터가_생성한_숫자는_중복이되면_안된다() {
        computer.generateNumbers();
        List<Integer> numbers = computer.getNumbers();
        Set<Integer> result = new HashSet<>(numbers);
        Assertions.assertThat(result.size())
                .isEqualTo(3);
    }

    @Test
    void 컴퓨터가_숫자를_재성성하면_기존_숫자와_달라야한다() {
        computer.generateNumbers();
        List<Integer> numbers1 = computer.getNumbers();
        computer.generateNumbers();
        List<Integer> numbers2 = computer.getNumbers();

        Assertions.assertThat(numbers1)
                .isNotEqualTo(numbers2);
    }
}