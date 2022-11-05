package baseball.player;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class ComputerTest {

    private Computer computer = new Computer();

    @Test
    void 생성된_문제가_1과_9사이의_숫자로_구성되어있는지_검증하는_테스트() {
        computer.createProblem();
        List<Integer> problem = computer.getProblem();
        boolean check = true;

        for (int i = 0; i < problem.size(); i++) {
            if (!(1 <= problem.get(i) && problem.get(i) <= 9)) {
                check = false;
            }
        }

        assertThat(check).isEqualTo(true);
    }

    @Test
    void 생성된_문제의_길이가_3인지_검증하는_테스트() {
        computer.createProblem();
        List<Integer> problem = computer.getProblem();

        assertThat(problem.size()).isEqualTo(3);
    }
}