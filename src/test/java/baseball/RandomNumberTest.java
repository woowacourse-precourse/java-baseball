package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RandomNumberTest {

    @Test
    void isRandomNumberLengthEqualsThree(){
        RandomNumber computer = new RandomNumber();
        computer.setRandomNumber();
        assertEquals(3, String.valueOf(computer.getRandomNumber()).length());
    }

}