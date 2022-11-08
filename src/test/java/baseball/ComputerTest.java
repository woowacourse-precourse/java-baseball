package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComputerTest {

    private Computer computer;

    @BeforeEach
    void 랜덤_숫자_생성() {
        computer = new Computer();
        computer.setRandomNumber();
    }
    @Test
    void 랜덤_숫자_길이_검증(){
        assertEquals(3, String.valueOf(computer.getRandomNumber()).length());
    }

    @Test
    void 랜덤_숫자_각_자리수_비교() {
        String randomNumber = String.valueOf(computer.getRandomNumber());
        boolean check1 = !randomNumber.substring(0,1).equals(randomNumber.substring(1,2));
        boolean check2 = !randomNumber.substring(1,2).equals(randomNumber.substring(2,3));
        boolean check3 = !randomNumber.substring(0,1).equals(randomNumber.substring(2,3));
        assertTrue(check1 && check2 && check3);

    }

}