package baseball;

import baseball.domain.ComputerBall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerBallTest {
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 9;
    private static final int COMPUTER_NUM_LENGTH = 3;

    @Test
    void 컴퓨터_3자리_숫자(){
        ComputerBall computerBall = new ComputerBall();
        computerBall.generateComputerNum();

        assertThat(computerBall.computerNumber.size()).isEqualTo(3);
    }

    @Test
    void 컴퓨터_숫자_1과_9사이의_범위(){
        ComputerBall computerBall = new ComputerBall();
        computerBall.generateComputerNum();

        for(int i=0; i<COMPUTER_NUM_LENGTH; i++) {
            assertThat(computerBall.computerNumber.get(i)).isBetween(MIN_NUM, MAX_NUM);
        }
    }

    @Test
    void 컴퓨터_숫자_중복(){
        ComputerBall computerBall = new ComputerBall();
        computerBall.generateComputerNum();

        Set<Integer> uniqueComputerBall = new HashSet<Integer>(computerBall.computerNumber);

        assertThat(uniqueComputerBall.size()).isEqualTo(3);
    }
}
