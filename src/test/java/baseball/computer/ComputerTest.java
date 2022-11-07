package baseball.computer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ComputerTest {
    private Computer computer;

    @BeforeEach
    void createComputer(){
        computer = new Computer();
    }

    @Test
    void 컴퓨터랜덤값이_세자리인지(){
        assertThat(computer.getComputerNum().size()).isEqualTo(3);
    }

    @Test
    void 컴퓨터랜덤값이_서로_다른_숫자인지(){
        assertThat(computer.getComputerNum().stream().distinct().count()).isEqualTo(3);
    }
}
