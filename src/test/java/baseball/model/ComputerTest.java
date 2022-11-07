package baseball.model;
import baseball.model.Computer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
 class ComputerTest {

     private static final int FIRST_INDEX = 0;
     private static final int SECOND_INDEX = 1;
     private static final int THIRD_INDEX = 2;
     private static final int NUMBERS_SIZE = 3;

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

     @Test
     void 숫자_생성시_모두_다른_3개_1부터_9의_자연수(){
         computer.makeThreeDigitNumber();
         assertThat(computer.getNumbers().get(FIRST_INDEX)).isNotEqualTo(computer.getNumbers().get(SECOND_INDEX));
         assertThat(computer.getNumbers().get(SECOND_INDEX)).isNotEqualTo(computer.getNumbers().get(THIRD_INDEX));
         assertThat(computer.getNumbers().get(THIRD_INDEX)).isNotEqualTo(computer.getNumbers().get(FIRST_INDEX));
         assertThat(computer.getNumbers().size()).isEqualTo(NUMBERS_SIZE);
     }

}
