package baseball.model;
import baseball.model.Computer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
 class ComputerTest {

    Computer computer;

    @BeforeEach
    void initializeComputer(){
        computer = new Computer();
    }

    /*
    @Test
    void 랜덤값은_1부터_9사이(){
        assertThat(computer.createRandomNumber()).isLessThanOrEqualTo(9)
                .isGreaterThanOrEqualTo(1);
    }

    @Test
    void 값을_입력하면_리스트에_저장(){
        computer.putNumber(1);
        assertThat(computer.getNumbers()).contains(1);
    }

    @Test
    void 값이_이미_있으면_참(){
        computer.putNumber(1);
        assertThat(computer.isAlreadyInNumbers(1)).isTrue();
    }

    @Test
    void 값이_없으면_거짓(){
        computer.putNumber(1);
        assertThat(computer.isAlreadyInNumbers(2)).isFalse();
    }
     */

}
